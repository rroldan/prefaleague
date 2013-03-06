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

import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.Query;

import org.ibertech.shared.Team;

public class TeamManager {
	//private Hashtable<String, Team> teams = new Hashtable<String, Team>();
	//private ITeamRepository teamsRepository;
	public List<Team> listTeam;	
	public TeamManager() {
//		getTeams();
//		EntityManager em = EMFService.get().createEntityManager();
//		Team team = new Team();
//		team.setTeamName("Prueba");
//		team.setCoach("yo");
//		team.setRace("No Muertos");
//		team.setNumFebb("1111");
//		team.setClub("Prueba");
//		 try {
//	            em.persist(team);
//	            
//	        } finally {
//	            em.close();
//	        }
	 
		//teams.put("yo", team);
//		teamsRepository = TeamsRepositoryFactory.getTeamsRepository();
//		teams = teamsRepository.getAllTeam();
		//teams = new ArrayList<Team>();
		
	}

	public List<Team> getTeams() {
		EntityManager em = EMFService.get().createEntityManager();
		 try {
	           Query q = em.createQuery("select t from Team t");
	           listTeam = new ArrayList<Team>(q.getResultList());
	        } finally {
	            em.close();
	        }
	 
		return listTeam;
	}

//	public void addContact(Contact contact) {
//		contactsRepository.addContact(contact);
//		saveContact(contact);
//	}

	public void saveTeam(Team team) {
		EntityManager em = EMFService.get().createEntityManager();
		if(team.getTeamId() != null){
			try {
				//em.getTransaction().begin();
				em.merge(team);
				//em.getTransaction().commit();
					            
	        } finally {
	            em.close();
	        }
		}else {
			try {
				em.persist(team);
	            em.refresh(team);
	        } finally {
	            em.close();
	        }
		}
		
		//teams.put(team.getCoach(),team);
		System.out.println(team);
			//		teamsRepository.saveTeam(team);
			//		teams = teamsRepository.getAllTeam();
	}

	public void deleteTeam(Team team) {
		EntityManager em = EMFService.get().createEntityManager();
		try {
			Team teamErase = em.find(Team.class,team.getTeamId());
		  	em.remove(teamErase);
		  	em.refresh(teamErase);
		             
        } finally {
        	em.close(); //Cuando no hay transacciones.
        }
				
		//teams.remove(team.getCoach());
		System.out.println(team);
//		Team originalTeam = getTeamByCoach(team.getCoach());
//		if (originalTeam != null) {
//			teamsRepository.removeTeam(originalTeam);
//			teams = teamsRepository.getAllTeam();
//		}
		
	}

	public int getTeamIndex(Team team) {
		int i = 0;
		for (Team teamLoop : listTeam) {
			if (teamLoop.getTeamId() == team.getTeamId()) {
				return i;
			}
			i++;
		}
		return -1;
	}

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
