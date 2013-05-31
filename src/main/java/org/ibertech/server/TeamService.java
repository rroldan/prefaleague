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

package org.ibertech.server;

import java.util.List;

import org.ibertech.client.ITeamService;
import org.ibertech.shared.Team;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;


@SuppressWarnings("serial")
public class TeamService extends RemoteServiceServlet implements ITeamService {

	private final TeamManager teamManager;

	public TeamService() {
		teamManager = new TeamManager();
	}

	
	public List<Team> getAllTeam() throws IllegalArgumentException {
		return teamManager.getTeams();
	}

	
	public void saveTeam(Team team) {
		teamManager.saveTeam(team);
	}

	
	public Team getTeam(String email) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void addTeam(Team team) {
		// TODO Auto-generated method stub
		
	}

	
	public void deleteTeam(Team team) {
		teamManager.deleteTeam(team);
		
	}
}
