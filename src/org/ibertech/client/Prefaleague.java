package org.ibertech.client;

import org.ibertech.client.mvp.AppPlaceHistoryMapper;
import org.ibertech.client.mvp.CenterActivityMapper;
import org.ibertech.client.mvp.SouthActivityMapper;
import org.ibertech.client.place.TeamPlace;
import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.SplitLayoutPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.web.bindery.event.shared.EventBus;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Prefaleague implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";

	/**
	 * Create a remote service proxy to talk to the server-side Greeting service.
	 */
	private final ITeamServiceAsync teamService = GWT
			.create(ITeamService.class);
	
	
	private final Place defaultPlace = new TeamPlace("");
	private final DockLayoutPanel dockLayoutPanel = new DockLayoutPanel(Unit.EM);
	private final SplitLayoutPanel splitLayoutPanel = new SplitLayoutPanel();
	private final SimplePanel centerPanel = new SimplePanel();
	private final SimplePanel southPanel = new SimplePanel();
	
	AcceptsOneWidget centerDisplay = new AcceptsOneWidget() {
		@Override
		public void setWidget(IsWidget activityWidget) {
			Widget widget = Widget.asWidgetOrNull(activityWidget);
			centerPanel.setVisible(widget != null);
			centerPanel.setWidget(widget);
		}
	};
	
	AcceptsOneWidget southDisplay = new AcceptsOneWidget() {
		double oldSize = 223.0; // TODO store real size dynamically

		@Override
		public void setWidget(IsWidget activityWidget) {
			Widget widget = Widget.asWidgetOrNull(activityWidget);
			if (widget == null) {
				splitLayoutPanel.setWidgetSize(southPanel, 0);
			} else {
				splitLayoutPanel.setWidgetSize(southPanel, oldSize);
			}
			southPanel.setVisible(widget != null);
			southPanel.setWidget(widget);
		}
	};

	private IClientFactory clientFactory;

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		southPanel.setStyleName("greyBackground");
		centerPanel.setStyleName("greyBackground");
		
		splitLayoutPanel.addSouth(southPanel, 223);
		splitLayoutPanel.add(centerPanel);
		splitLayoutPanel.setStyleName("gwt-SplitLayoutPanel");
		
		dockLayoutPanel.add(splitLayoutPanel);
		
		clientFactory = GWT.create(IClientFactory.class);

		EventBus eventBus = clientFactory.getEventBus();
		PlaceController placeController = clientFactory.getPlaceController();
		
		// Start CenterActivityManager for the center widget with the
		// CenterActivityMapper
		ActivityMapper centerActivityMapper = new CenterActivityMapper(clientFactory);
		ActivityManager centerActivityManager = new ActivityManager(centerActivityMapper, eventBus);
		centerActivityManager.setDisplay(centerDisplay);
		
		// Start SouthActivityManager for the south widget with the
		// SouthActivityMapper
		ActivityMapper southActivityMapper = new SouthActivityMapper(clientFactory);
		ActivityManager southActivityManager = new ActivityManager(southActivityMapper, eventBus);
		southActivityManager.setDisplay(southDisplay);
		
		// Start PlaceHistoryHandler with our PlaceHistoryMapper
		AppPlaceHistoryMapper historyMapper = GWT.create(AppPlaceHistoryMapper.class);
		PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
		historyHandler.register(placeController, eventBus, defaultPlace);

		RootLayoutPanel.get().add(dockLayoutPanel);

		// Goes to place represented on URL or default place
		historyHandler.handleCurrentHistory();

		
	}
	
	/*
	 * For better UI testability with gwt-test-utils
	 */
	public IClientFactory getClientFactory() {
		return clientFactory;
	}
}
