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

import org.ibertech.client.ui.ITeamDetailsView;
import org.ibertech.client.ui.ITeamListView;
import org.ibertech.client.ui.TeamDetailsView;
import org.ibertech.client.ui.TeamListView2;
import org.ibertech.shared.Team;

import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;

public class ClientFactory implements IClientFactory {
	private static final EventBus eventBus = new SimpleEventBus();
	private static final PlaceController placeController = new PlaceController(eventBus);

	private static final ITeamListView teamListView = new TeamListView2();

	private static final ITeamDetailsView teamDetailsView = new TeamDetailsView();

	//private static final IToolBarView toolBarView = new ToolBarView();

	private final ITeamServiceAsync teamService = GWT.create(ITeamService.class);
	private List<Team> teams;

	@Override
	public EventBus getEventBus() {
		return eventBus;
	}

//	@Override
//	public IToolBarView getToolBarView() {
//		return toolBarView;
//	}

	@Override
	public ITeamListView getTeamListView() {
		return teamListView;
	}

	@Override
	public ITeamDetailsView getTeamDetailsView() {
		return teamDetailsView;
	}

	@Override
	public PlaceController getPlaceController() {
		return placeController;
	}

	@Override
	public ITeamServiceAsync getTeamService() {
		return teamService;
	}

	@Override
	public List<Team> getTeams() {
		return teams;
	}

	@Override
	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}
}
