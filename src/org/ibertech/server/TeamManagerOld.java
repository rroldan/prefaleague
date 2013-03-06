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

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.ibertech.shared.Team;

public class TeamManagerOld {
	private Hashtable<String, Team> teams = new Hashtable<String, Team>();
	//private ITeamRepository teamsRepository;

	public TeamManagerOld() {
		Team team = new Team();
		team.setTeamName("Prueba");
		team.setCoach("yo");
		team.setRace("No Muertos");
		team.setNumFebb("1111");
		team.setClub("Prueba");
		teams.put("yo", team);
//		teamsRepository = TeamsRepositoryFactory.getTeamsRepository();
//		teams = teamsRepository.getAllTeam();
		//teams = new ArrayList<Team>();
		
	}

	public List<Team> getTeams() {
		List<Team> listTeam = new ArrayList<Team>();
		for(Team team : teams.values())
			listTeam.add(team);
		return listTeam;
	}

//	public void addContact(Contact contact) {
//		contactsRepository.addContact(contact);
//		saveContact(contact);
//	}

	public void saveTeam(Team team) {
		teams.put(team.getCoach(),team);
		System.out.println(team);
			//		teamsRepository.saveTeam(team);
			//		teams = teamsRepository.getAllTeam();
	}

	public void deleteTeam(Team team) {
		teams.remove(team.getCoach());
		System.out.println(team);
//		Team originalTeam = getTeamByCoach(team.getCoach());
//		if (originalTeam != null) {
//			teamsRepository.removeTeam(originalTeam);
//			teams = teamsRepository.getAllTeam();
//		}
		
	}

//	public int getContactIndex(Contact contact) {
//		int i = 0;
//		for (Contact contactInList : contacts) {
//			if (contactInList == contact) {
//				return i;
//			}
//			i++;
//		}
//		return -1;
//	}

//	public Contact getContactByEmail(String email) {
//		for (Contact contact : contacts) {
//			if (email.equals(contact.getEmail())) {
//				return contact;
//			}
//		}
//		return null;
//	}
//
//	public Team getTeamByCoach(String coach) {
//		for (Team team : teams.values()) {
//			if (coach.equals(team.getCoach())) {
//				return team;
//			}
//		}
//		return null;
//	}

}
