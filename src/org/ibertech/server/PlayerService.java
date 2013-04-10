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

import org.ibertech.client.IPlayerService;
import org.ibertech.client.ITeamService;
import org.ibertech.shared.Player;
import org.ibertech.shared.Team;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;


@SuppressWarnings("serial")
public class PlayerService extends RemoteServiceServlet implements IPlayerService {

	private final PlayerManager playerManager;

	public PlayerService() {
		playerManager = new PlayerManager();
	}

	
//	@Override
//	public Contact getContact(String email) throws IllegalArgumentException {
//		return contactManager.getContactByEmail(email);
//	}

//	@Override
//	public void addContact(Contact contact) {
//		contactManager.addContact(contact);
//	}

	@Override
	public void savePlayer(Player player) {
		playerManager.savePlayer(player);
	}

	@Override
	public Player getPlayer(String name) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public void deletePlayer(Player player) {
		playerManager.deletePlayer(player);
		
	}


	@Override
	public void addPlayer(Player player) {
		// TODO Auto-generated method stub
		
	}
	
	
	@Override
	public List<Player> getAllPlayer() throws IllegalArgumentException {
		return playerManager.getAllPlayer();
	}

}
