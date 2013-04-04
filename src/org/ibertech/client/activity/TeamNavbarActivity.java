package org.ibertech.client.activity;

import org.ibertech.client.IClientFactory;
import org.ibertech.client.place.TeamPlace;
import org.ibertech.client.ui.ITeamNavbarView;
import org.ibertech.client.ui.ITeamNavbarView.Presenter;
import org.ibertech.client.ui.TeamNavbarView;
import org.ibertech.shared.Team;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.DeckLayoutPanel;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.RootLayoutPanel;


public class TeamNavbarActivity extends AbstractActivity implements Presenter {

	private final IClientFactory clientFactory;
	private ITeamNavbarView teamNavbarView;
	private final String token;
	private final Place place;
	
	

	public TeamNavbarActivity(TeamPlace place, IClientFactory clientFactory) {
		this.clientFactory = clientFactory;
		token = place.getToken();
		this.place = place;
		System.out.println("TeamNavbarAvtivity.TeamDetailsActivity() token: " + token);
	}
	
	
    @Override
	public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
		System.out.println("ToolBarActivity.start()");
		teamNavbarView = clientFactory.getTeamNavbarView();
		teamNavbarView.setPresenter(this);
		containerWidget.setWidget(teamNavbarView.asWidget());
	}

	@Override
	public String mayStop() {
		teamNavbarView.setPresenter(null);
		return null;
	}


	@Override
	public void goTo(Place place) {
		System.out.println("TeamDetailsActivity.goTo()");
		clientFactory.getPlaceController().goTo(place);
		
	}


	@Override
	public void groupsOption() {
		System.out.println("Funciona el bóton");
		DockLayoutPanel dockLayoutPanel2 = (DockLayoutPanel)RootLayoutPanel.get().getWidget(0);
		DeckLayoutPanel deckLayoutPanel = (DeckLayoutPanel)dockLayoutPanel2.getWidget(1);
		deckLayoutPanel.showWidget(0);
		
	
	}


	@Override
	public void groupsPlayers() {
		System.out.println("Funciona el bóton");
		
	}


	
}
