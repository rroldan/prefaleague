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
import org.ibertech.client.ITeamServiceAsync;
import org.ibertech.client.event.TeamViewEvent;
import org.ibertech.client.place.TeamEditPlace;
import org.ibertech.client.place.TeamPlace;
import org.ibertech.client.ui.ITeamDetailsView;
import org.ibertech.shared.Team;

import com.github.gwtbootstrap.client.ui.constants.ControlGroupType;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class TeamDetailsActivity extends AbstractActivity implements ITeamDetailsView.Presenter {
	
	private Logger logger = Logger.getLogger("");

	private final IClientFactory clientFactory;
	private EventBus eventBus;
	private TeamViewEvent.Handler handler;
	private final String token;
	private ITeamDetailsView teamDetailsView;
	private final Place place;
	
	public TeamDetailsActivity(TeamPlace place, IClientFactory clientFactory) {
		this.clientFactory = clientFactory;
		token = place.getToken();
		this.place = place;
		logger.log(Level.FINE,"TeamDetailsActivity.TeamDetailsActivity() token: " + token);
	}

	public TeamDetailsActivity(TeamEditPlace place, IClientFactory clientFactory) {
		this.clientFactory = clientFactory;
		token = place.getToken();
		this.place = place;
		System.out.println("TeamDetailsActivity.TeamDetailsActivity() token: " + token);
	}

	
	public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
		System.out.println("TeamDetailsActivity.start()");
		ActivityRegistry.setTeamDetailsActivity(this);
		teamDetailsView = clientFactory.getTeamDetailsView();
		this.eventBus = eventBus;
		teamDetailsView.setPresenter(this);
		if (place instanceof TeamEditPlace || (place instanceof TeamPlace && token.length() == 0)) {
			teamDetailsView.clear();
		}
		handler = new TeamViewEvent.Handler() {

			
			public void onTeamView(TeamViewEvent event) {
				System.out.println("TeamDetailsActivity onContactView()");
				teamDetailsView.clear();
				teamDetailsView.setTeam(event.getTeam());
			}
		};
		this.eventBus.addHandler(TeamViewEvent.TYPE, handler);

		containerWidget.setWidget(teamDetailsView.asWidget());
	}

	
	public String mayStop() {
		teamDetailsView.setPresenter(null);
		ActivityRegistry.setTeamDetailsActivity(null);
		return null;
	}

	/**
	 * @see IContactDetailsView.Presenter#goTo(Place)
	 */
	
	public void goTo(Place place) {
		System.out.println("TeamDetailsActivity.goTo()");
		clientFactory.getPlaceController().goTo(place);
	}

	
	public Team getTeam() {
		return teamDetailsView.getTeam();
	}

	
	public void saveTeam() {
		// TODO Auto-generated method stub
		System.out.println("Funciona el b�ton");
		ITeamServiceAsync teamService = clientFactory.getTeamService();
		Team team = getTeam();
		
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<Team>> violations = validator.validate(team);
		
		if (!violations.isEmpty()) {
		     // StringBuffer errorMessage = new StringBuffer();
		      for (ConstraintViolation<Team> constraintViolation : violations) {
//		        if (errorMessage.length() == 0) {
//		          errorMessage.append('\n');
//		        }
		        //errorMessage.append(constraintViolation.getMessage());
		    	  
		    	//  userNameControlGroup.setType(ControlGroupType.ERROR);
				//	userNameHelpInline.setText("UserName should be input");  
		        teamDetailsView.getGroupNameControlGroup().setType(ControlGroupType.ERROR);
		        //teamDetailsView.getTBTeamName().setStyleName(".gwt-TextBox");
		        
		      }
		      //errorLabel.setText(errorMessage.toString());
		      return;
		}
		
		teamService.saveTeam(team, new AsyncCallback<Void>() {
				
			
			public void onSuccess(Void result) {
				System.out.println("Team saved");
				clientFactory.setTeams(null);
				clientFactory.getPlaceController().goTo(new TeamPlace(""));
				
			}

			
			public void onFailure(Throwable caught) {
				System.err.println("Cannot save team");
			}
		});
		
	}

	
	public void delteTeam() {
		System.out.println("TeamDetailsActivity.deleteTeam()");
		TeamDetailsActivity teamDetailsActivity = ActivityRegistry.getTeamDetailsActivity();
		if (teamDetailsActivity != null) {
			final Team team = teamDetailsActivity.getTeam();
			ITeamServiceAsync teamService = clientFactory.getTeamService();
			teamService.deleteTeam(team, new AsyncCallback<Void>() {

				
				public void onSuccess(Void result) {
					System.out.println("Team deleted");
					clientFactory.setTeams(null);
					clientFactory.getPlaceController().goTo(new TeamPlace(""));
				}

				
				public void onFailure(Throwable caught) {
					System.err.println("Cannot delete team: " + team);
				}
			});
		}
		
	}

	
}
