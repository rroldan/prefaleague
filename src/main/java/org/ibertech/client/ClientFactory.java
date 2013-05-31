/*******************************************************************************
 * Copyright (c) 2012 Kai Toedter and others.
 * 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html.
 * 
 * Contributors:
 *     Kai Toedter - initial API and implementation
 ******************************************************************************/

package org.ibertech.client;

import java.util.List;

import org.ibertech.client.ui.IPlayerDetailsView;
import org.ibertech.client.ui.IPlayerListView;
import org.ibertech.client.ui.ITeamDetailsView;
import org.ibertech.client.ui.ITeamListView;
import org.ibertech.client.ui.ITeamNavbarView;
import org.ibertech.client.ui.PlayerDetailsView;
import org.ibertech.client.ui.PlayerListView2;
import org.ibertech.client.ui.TeamDetailsView;
import org.ibertech.client.ui.TeamListView2;
import org.ibertech.client.ui.TeamNavbarView;
import org.ibertech.shared.Player;
import org.ibertech.shared.Team;

import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;

public class ClientFactory implements IClientFactory {
	private static final EventBus eventBus = new SimpleEventBus();
	private static final PlaceController placeController = new PlaceController(eventBus);

	private static final ITeamListView teamListView = new TeamListView2();
	private static final IPlayerListView playerListView = new PlayerListView2();

	private static final ITeamDetailsView teamDetailsView = new TeamDetailsView();
	private static final IPlayerDetailsView playerDetailsView = new PlayerDetailsView();

	private static final ITeamNavbarView teamNavbarView = new TeamNavbarView();

	private final ITeamServiceAsync teamService = GWT.create(ITeamService.class);
	private final IPlayerServiceAsync playerService = GWT.create(IPlayerService.class);
	private List<Team> teams;
	private List<Player> players;

	
	public EventBus getEventBus() {
		return eventBus;
	}

//	@Override
//	public IToolBarView getToolBarView() {
//		return toolBarView;
//	}

	
	public ITeamListView getTeamListView() {
		return teamListView;
	}

	
	public ITeamDetailsView getTeamDetailsView() {
		return teamDetailsView;
	}

	
	public PlaceController getPlaceController() {
		return placeController;
	}

	
	public ITeamServiceAsync getTeamService() {
		return teamService;
	}

	
	public List<Team> getTeams() {
		return teams;
	}

	
	
	public ITeamNavbarView getTeamNavbarView() {
		// TODO Auto-generated method stub
		return teamNavbarView;
	}

	
	public IPlayerServiceAsync getPlayerService() {
		// TODO Auto-generated method stub
		return playerService;
	}

	
	public IPlayerListView getPlayerListView() {
		// TODO Auto-generated method stub
		return playerListView;
	}

	
	public List<Player> getPlayer() {
		// TODO Auto-generated method stub
		return players;
	}

	
	public void setPlayers(List<Player> player) {
		this.players = player;
		
	}

	
	public IPlayerDetailsView getPlayerDetailsView() {
		// TODO Auto-generated method stub
		return playerDetailsView;
	}

	
	public void setTeams(List<Team> team) {
		this.teams = team;
		
	}

	

	
	
}
