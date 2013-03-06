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
import org.ibertech.shared.Team;

import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;

public interface IClientFactory {
	EventBus getEventBus();

	PlaceController getPlaceController();

	ITeamListView getTeamListView();

	ITeamDetailsView getTeamDetailsView();

	//IToolBarView getToolBarView();

	ITeamServiceAsync getTeamService();

	List<Team> getTeams();

	void setTeams(List<Team> team);
}
