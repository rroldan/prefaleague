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

import org.ibertech.shared.Player;
import org.ibertech.shared.Team;

public class PlayerManager {
	
	public List<Player> listPlayer;	
	
	public PlayerManager() {
		getPlayer();
	}

	public List<Player> getPlayer() {
		EntityManager em = EMFService.get().createEntityManager();
		 try {
	           Query q = em.createQuery("select t from Player t");
	           listPlayer = new ArrayList<Player>(q.getResultList());
	        } finally {
	            em.close();
	        }
	 
		return listPlayer;
	}


	public void savePlayer(Player player) {
		EntityManager em = EMFService.get().createEntityManager();
		if(player.getPlayerId() != null){
			try {
				//em.getTransaction().begin();
				em.merge(player);
				//em.getTransaction().commit();
					            
	        } finally {
	            em.close();
	        }
		}else {
			try {
				em.persist(player);
	            em.refresh(player);
	        } finally {
	            em.close();
	        }
		}
		
		//teams.put(team.getCoach(),team);
		System.out.println(player);
			//		teamsRepository.saveTeam(team);
			//		teams = teamsRepository.getAllTeam();
	}

	public void deletePlayer(Player player) {
		EntityManager em = EMFService.get().createEntityManager();
		try {
			Player playerErase = em.find(Player.class,player.getPlayerId());
		  	em.remove(playerErase);
		  	em.refresh(playerErase);
		             
        } finally {
        	em.close(); //Cuando no hay transacciones.
        }
				
		System.out.println(player);		
	}

	
	public int getPlayerIndex(Player player) {
		int i = 0;
		for (Player playerLoop : listPlayer) {
			if (playerLoop.getPlayerId() == player.getPlayerId()) {
				return i;
			}
			i++;
		}
		return -1;
	}
	
	
	public List<Player> getAllPlayer() {
		return null;
	}
	
}
