package org.ibertech.client.activity;


import org.ibertech.client.IClientFactory;
import org.ibertech.client.place.PlayerPlace;
import org.ibertech.client.place.TeamPlace;
import org.ibertech.client.ui.ITeamNavbarView;
import org.ibertech.client.ui.ITeamNavbarView.Presenter;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.DeckLayoutPanel;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.RootLayoutPanel;

import java.util.logging.Level;
import java.util.logging.Logger;


public class TeamNavbarActivity extends AbstractActivity implements Presenter {
	
	Logger logger = Logger.getLogger("");

	private final IClientFactory clientFactory;
	private ITeamNavbarView teamNavbarView;
	private final String token;
	private final Place place;
	
	

	public TeamNavbarActivity(TeamPlace place, IClientFactory clientFactory) {
		this.clientFactory = clientFactory;
		token = place.getToken();
		this.place = place;
		logger.log(Level.FINE, "TeamNavbarAvtivity.TeamDetailsActivity() token: " + token);
	}


    public TeamNavbarActivity(PlayerPlace place, IClientFactory clientFactory) {
        this.clientFactory = clientFactory;
        token = place.getToken();
        this.place = place;
        logger.log(Level.FINE, "TeamNavbarAvtivity.TeamDetailsActivity() token: " + token);
    }
	
	
    
	public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
		logger.log(Level.FINE,"ToolBarActivity.start()");
		teamNavbarView = clientFactory.getTeamNavbarView();
		teamNavbarView.setPresenter(this);
		containerWidget.setWidget(teamNavbarView.asWidget());
	}

	
	public String mayStop() {
		teamNavbarView.setPresenter(null);
		return null;
	}


	
	public void goTo(Place place) {
		logger.log(Level.FINE,"TeamDetailsActivity.goTo()");
		clientFactory.getPlaceController().goTo(place);
		
    }

	
	public void groupsOption() {
		logger.log(Level.FINE,"press button groups");
        Place teamPlace = new TeamPlace("");
        clientFactory.getPlaceController().goTo(teamPlace);
		DockLayoutPanel dockLayoutPanel2 = (DockLayoutPanel)RootLayoutPanel.get().getWidget(0);
		DeckLayoutPanel deckLayoutPanel = (DeckLayoutPanel)dockLayoutPanel2.getWidget(1);
		deckLayoutPanel.showWidget(0);
		
	
	}


	
	public void groupsPlayers() {
		logger.log(Level.FINE,"press buton player");
        Place playerPlace = new PlayerPlace("");
        clientFactory.getPlaceController().goTo(playerPlace);
		DockLayoutPanel dockLayoutPanel2 = (DockLayoutPanel)RootLayoutPanel.get().getWidget(0);
		DeckLayoutPanel deckLayoutPanel = (DeckLayoutPanel)dockLayoutPanel2.getWidget(1);
		deckLayoutPanel.showWidget(2);
		
	}


	
}
