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

import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.border.Border;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import org.ibertech.client.IClientFactory;
import org.ibertech.client.IPlayerServiceAsync;
import org.ibertech.client.ITeamServiceAsync;
import org.ibertech.client.event.PlayerViewEvent;
import org.ibertech.client.event.TeamViewEvent;
import org.ibertech.client.place.PlayerEditPlace;
import org.ibertech.client.place.PlayerPlace;
import org.ibertech.client.place.TeamEditPlace;
import org.ibertech.client.place.TeamPlace;
import org.ibertech.client.ui.IPlayerDetailsView;
import org.ibertech.client.ui.ITeamDetailsView;
import org.ibertech.shared.Player;
import org.ibertech.shared.Team;

import com.github.gwtbootstrap.client.ui.constants.ControlGroupType;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class PlayerDetailsActivity extends AbstractActivity implements IPlayerDetailsView.Presenter {
	
	Logger logger = Logger.getLogger("");

	private final IClientFactory clientFactory;
	private EventBus eventBus;
	private PlayerViewEvent.Handler handler;
	private final String token;
	private IPlayerDetailsView playerDetailsView;
	private final Place place;
	
	public PlayerDetailsActivity(PlayerPlace place, IClientFactory clientFactory) {
		this.clientFactory = clientFactory;
		token = place.getToken();
		this.place = place;
		logger.log(Level.FINE, "PlayerDetailsActivity.PlayerDetailsActivity() token: " + token);
	}

	public PlayerDetailsActivity(PlayerEditPlace place, IClientFactory clientFactory) {
		this.clientFactory = clientFactory;
		token = place.getToken();
		this.place = place;
		logger.log(Level.FINE, "PlayerDetailsActivity.PlayerDetailsActivity() token: " + token);
	}

	
	public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
		System.out.println("PlayerDetailsActivity.start()");
		ActivityRegistry.setPlayerDetailsActivity(this);
		playerDetailsView = clientFactory.getPlayerDetailsView();
		this.eventBus = eventBus;
		playerDetailsView.setPresenter(this);
		if (place instanceof PlayerEditPlace || (place instanceof PlayerPlace && token.length() == 0)) {
			playerDetailsView.clear();
		}
		handler = new PlayerViewEvent.Handler() {

			
			public void onPlayerView(PlayerViewEvent event) {
				System.out.println("PlayerDetailsActivity onContactView()");
				playerDetailsView.clear();
				playerDetailsView.setPlayer(event.getPlayer());
			}
		};
		this.eventBus.addHandler(PlayerViewEvent.TYPE, handler);

		containerWidget.setWidget(playerDetailsView.asWidget());
	}

	
	public String mayStop() {
		playerDetailsView.setPresenter(null);
		ActivityRegistry.setTeamDetailsActivity(null);
		return null;
	}

	/**
	 * @see IContactDetailsView.Presenter#goTo(Place)
	 */
	
	public void goTo(Place place) {
		logger.log(Level.FINE, "PlayerDetailsActivity.goTo()");
		clientFactory.getPlaceController().goTo(place);
	}

	
	public Player getPlayer() {
		return playerDetailsView.getPlayer();
	}

	
	public void savePlayer() {
		// TODO Auto-generated method stub
		logger.log(Level.FINE, "Funciona el b�ton");
		IPlayerServiceAsync playerService = clientFactory.getPlayerService();
		Player player = getPlayer();
		
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<Player>> violations = validator.validate(player);
		
		if (!violations.isEmpty()) {
		     // StringBuffer errorMessage = new StringBuffer();
		      for (ConstraintViolation<Player> constraintViolation : violations) {
//		        if (errorMessage.length() == 0) {
//		          errorMessage.append('\n');
//		        }
		        //errorMessage.append(constraintViolation.getMessage());
		    	  
		    	//  userNameControlGroup.setType(ControlGroupType.ERROR);
				//	userNameHelpInline.setText("UserName should be input");  
		        playerDetailsView.getGroupNameControlGroup().setType(ControlGroupType.ERROR);
		        //teamDetailsView.getTBTeamName().setStyleName(".gwt-TextBox");
		        
		      }
		      //errorLabel.setText(errorMessage.toString());
		      return;
		}
		
		playerService.savePlayer(player, new AsyncCallback<Void>() {
				
			
			public void onSuccess(Void result) {
				logger.log(Level.FINE, "Player saved");
				clientFactory.setTeams(null);
				clientFactory.getPlaceController().goTo(new PlayerPlace(""));
				
			}

			
			public void onFailure(Throwable caught) {
				logger.log(Level.FINE, "Cannot save team");
			}
		});
		
	}

	
	public void deltePlayer() {
		logger.log(Level.FINE, "TeamDetailsActivity.deleteTeam()");
		PlayerDetailsActivity playerDetailsActivity = ActivityRegistry.getPlayerDetailsActivity();
		if (playerDetailsActivity != null) {
			final Player player = playerDetailsActivity.getPlayer();
			IPlayerServiceAsync playerService = clientFactory.getPlayerService();
			playerService.deletePlayer(player, new AsyncCallback<Void>() {

				
				public void onSuccess(Void result) {
					logger.log(Level.FINE, "Team deleted");
					clientFactory.setTeams(null);
					clientFactory.getPlaceController().goTo(new TeamPlace(""));
				}

				
				public void onFailure(Throwable caught) {
					System.err.println("Cannot delete player: " + player);
				}
			});
		}
		
	}

	
	
	
}
