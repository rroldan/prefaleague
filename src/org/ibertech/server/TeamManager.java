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
	
	public TeamManager() {

		
	}

	public List<Team> getTeams() {
	    List<Team> listTeam;
		EntityManager em = EMFService.get().createEntityManager();
		 try {
	           Query q = em.createQuery("select t from Team t");
	           listTeam = new ArrayList<Team>(q.getResultList());
	        } finally {
	            em.close();
	        }
	 
		return listTeam;
	}


	public void saveTeam(Team team) {
		EntityManager em = EMFService.get().createEntityManager();
		if(team.getTeamId() != null){
			try {			
				em.merge(team);		            
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
		
		System.out.println(team);
			
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
				
		System.out.println(team);

		
	}

	public int getTeamIndex(Team team) {
		int i = 0;
		List<Team> listTeam = getTeams();
		for (Team teamLoop : listTeam) {
			if (teamLoop.getTeamId() == team.getTeamId()) {
				return i;
			}
			i++;
		}
		return -1;
	}



}
