package org.ibertech.client;

import org.ibertech.client.mvp.AppPlaceHistoryMapper;
import org.ibertech.client.mvp.CenterActivityMapper;
import org.ibertech.client.mvp.PlayerDetailsActivityMapper;
import org.ibertech.client.mvp.NorthActivityMapper;
import org.ibertech.client.mvp.PlayerListActivityMapper;
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
import com.google.gwt.user.client.ui.DeckLayoutPanel;
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
	private final DeckLayoutPanel deckLayoutPanel = new DeckLayoutPanel();

	
	//private final SplitLayoutPanel splitLayoutPanel = new SplitLayoutPanel();
	private final SimplePanel centerPanel = new SimplePanel();
	private final SimplePanel southPanel =  new SimplePanel();
	private final SimplePanel northPanel =  new SimplePanel();
    private final SimplePanel playerListPanel = new SimplePanel();
    private final SimplePanel playerDetailsPanel = new SimplePanel();
    
    AcceptsOneWidget playerListDisplay = new AcceptsOneWidget() {
		
		public void setWidget(IsWidget activityWidget) {
			Widget widget = Widget.asWidgetOrNull(activityWidget);
			playerListPanel.setWidget(widget);
		}
	};
	
	AcceptsOneWidget playerDetailsDisplay = new AcceptsOneWidget() {
		
		public void setWidget(IsWidget activityWidget) {
			Widget widget = Widget.asWidgetOrNull(activityWidget);
			playerDetailsPanel.setWidget(widget);
		}
		
	};
	
	AcceptsOneWidget centerDisplay = new AcceptsOneWidget() {
		
		public void setWidget(IsWidget activityWidget) {
			Widget widget = Widget.asWidgetOrNull(activityWidget);
			//centerPanel.setVisible(widget != null);
			centerPanel.setWidget(widget);
		}
	};
	
	AcceptsOneWidget southDisplay = new AcceptsOneWidget() {
		double oldSize = 223.0; // TODO store real size dynamically

		
		public void setWidget(IsWidget activityWidget) {
			Widget widget = Widget.asWidgetOrNull(activityWidget);
		//	if (widget == null) {
		//		splitLayoutPanel.setWidgetSize(southPanel, 0);
		//	} else {
		//		splitLayoutPanel.setWidgetSize(southPanel, oldSize);
		//	}
			southPanel.setVisible(widget != null);
			southPanel.setWidget(widget);
		}
	};
	
	AcceptsOneWidget northDisplay = new AcceptsOneWidget() {
		
		public void setWidget(IsWidget activityWidget) {
			Widget widget = Widget.asWidgetOrNull(activityWidget);
			northPanel.setVisible(widget != null);
			northPanel.setWidget(widget);
		}
	};
	

	private IClientFactory clientFactory;

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		southPanel.setStyleName("greyBackground");
		centerPanel.setStyleName("greyBackground");
		northPanel.setStyleName("darkGreyBackground");
		//centerPanel.setVisible(false);
		
		//splitLayoutPanel.addWest(centerPanel, 128);
		//splitLayoutPanel.addEast(southPanel,320);
		//splitLayoutPanel.setStyleName("gwt-SplitLayoutPanel");
		
		deckLayoutPanel.add(southPanel);
		deckLayoutPanel.add(centerPanel);
		
		deckLayoutPanel.add(playerListPanel);
		deckLayoutPanel.add(playerDetailsPanel);
		
		deckLayoutPanel.showWidget(1);
		dockLayoutPanel.addNorth(northPanel, 4.5);
		//dockLayoutPanel.addSouth(centerPanel,50);
		//dockLayoutPanel.add(southPanel);
		dockLayoutPanel.add(deckLayoutPanel);
		//dockLayoutPanel.add(splitLayoutPanel);
		
		clientFactory = GWT.create(IClientFactory.class);

		EventBus eventBus = clientFactory.getEventBus();
		PlaceController placeController = clientFactory.getPlaceController();
		
		ActivityMapper northActivityMapper = new NorthActivityMapper(clientFactory);
		ActivityManager northActivityManager = new ActivityManager(northActivityMapper, eventBus);
		northActivityManager.setDisplay(northDisplay);
		
		
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
		
		
		ActivityMapper  playerListActivityMapper = new PlayerListActivityMapper(clientFactory);
		ActivityManager playerListActivityManager = new ActivityManager(playerListActivityMapper, eventBus);
		playerListActivityManager.setDisplay(playerListDisplay);
		
		ActivityMapper playerDetailsActivityMapper = new PlayerDetailsActivityMapper(clientFactory);
		ActivityManager playerDetailsActivityManager = new ActivityManager(playerDetailsActivityMapper, eventBus);
		playerDetailsActivityManager.setDisplay(playerDetailsDisplay);
		
		
		
		
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
