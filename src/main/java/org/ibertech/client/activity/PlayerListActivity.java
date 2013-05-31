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

package org.ibertech.client.activity;

import java.util.List;

import org.ibertech.client.IClientFactory;
import org.ibertech.client.IPlayerServiceAsync;
import org.ibertech.client.ITeamServiceAsync;
import org.ibertech.client.event.TeamViewEvent;
import org.ibertech.client.place.PlayerPlace;
import org.ibertech.client.place.TeamPlace;
import org.ibertech.client.ui.IPlayerListView;
import org.ibertech.client.ui.ITeamListView;
import org.ibertech.shared.Player;
import org.ibertech.shared.Team;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.DeckLayoutPanel;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.RootLayoutPanel;

public class PlayerListActivity extends AbstractActivity implements IPlayerListView.Presenter {
	private final IClientFactory clientFactory;
	private final String token;
	private EventBus eventBus;
	private IPlayerListView playerListView;

	public PlayerListActivity(PlayerPlace place, IClientFactory clientFactory) {
		System.out.println("PlayerListActivity.playerListActivity()");
		token = place.getToken();
		this.clientFactory = clientFactory;
	}

	
	public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
		System.out.println("TeamListActivity.start()");
		ActivityRegistry.setPlayerListActivity(this);
		this.eventBus = eventBus;
		playerListView = clientFactory.getPlayerListView();
		playerListView.setPresenter(this);
		containerWidget.setWidget(playerListView.asWidget());

		if (clientFactory.getTeams() == null) {
			final long startTime = System.currentTimeMillis();
			IPlayerServiceAsync playerService = clientFactory.getPlayerService();
			playerService.getAllPlayer(new AsyncCallback<List<Player>>() {

				
				public void onSuccess(List<Player> result) {
					System.out.println("Time for RPC: " + (System.currentTimeMillis() - startTime));
					clientFactory.setPlayers(result);
					playerListView.initialize(result);
					if (token.length() > 0) {
						// views either deal with domain objects (Contact) or
						// just row indices
						int index = 0;//getTeamIndex(token);
						if (index != -1) {
							playerListView.selectInitialRow(index);
						}

						//selectInitialTeam(token);
					}
				}

				
				public void onFailure(Throwable caught) {
					System.err.println("Error in getting contacts form contact service");
				}
			});
		} else if (token.length() > 0) {
			//selectInitialTeam(token);
		}
	}

	
	public String mayStop() {
		playerListView.setPresenter(null);
		return null;
	}

	
	public void goTo(Place place) {
		clientFactory.getPlaceController().goTo(place);
	}

//	public void selectInitialContact(String email) {
//		Contact contact = getContact(email);
//		if (contact != null) {
//			contactListView.selectInitialContact(contact);
//			eventBus.fireEvent(new ContactViewEvent(contact));
//		}
//	}

	
	public void select(Team team) {
		//System.out.println("ContactListActivity.select(): " + token + ":" + contact.getEmail());
		
		DockLayoutPanel dockLayoutPanel2 = (DockLayoutPanel)RootLayoutPanel.get().getWidget(0);
		DeckLayoutPanel deckLayoutPanel = (DeckLayoutPanel)dockLayoutPanel2.getWidget(1);
		deckLayoutPanel.showWidget(1);
		
		eventBus.fireEvent(new TeamViewEvent(team));
//		if (token == null || (token != null && !token.equals(contact.getEmail()))) {
//			goTo(new ContactPlace(contact.getEmail()));
//		}
	}

	
	public void select(int index) {
//		System.out.println("ContactListActivity.select(): " + index);
//		Contact contact = clientFactory.getContacts().get(index);
//		eventBus.fireEvent(new ContactViewEvent(contact));
//		goTo(new ContactPlace(contact.getEmail()));
	}

//	private int getContactIndex(String email) {
//		int i = 0;
//		for (Contact contact : clientFactory.getContacts()) {
//			if (email.equals(contact.getEmail())) {
//				return i;
//			}
//			i++;
//		}
//		return -1;
//	}
//
//	private Contact getContact(String email) {
//		for (Contact contact : clientFactory.getContacts()) {
//			if (email.equals(contact.getEmail())) {
//				return contact;
//			}
//		}
//		return null;
//	}
}