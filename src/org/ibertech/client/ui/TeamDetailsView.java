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

package org.ibertech.client.ui;


import org.ibertech.shared.RaceConstants;
import org.ibertech.shared.Team;

import com.github.gwtbootstrap.client.ui.Button;
import com.github.gwtbootstrap.client.ui.ControlGroup;
import com.github.gwtbootstrap.client.ui.Label;
import com.github.gwtbootstrap.client.ui.ListBox;
import com.github.gwtbootstrap.client.ui.TextBox;
import com.github.gwtbootstrap.client.ui.constants.ControlGroupType;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;




public class TeamDetailsView extends Composite implements ITeamDetailsView {

	private static TeamDetailsViewUiBinder uiBinder = GWT.create(TeamDetailsViewUiBinder.class);
	
	@UiField TextBox tbTeamName;
	@UiField TextBox tbCoach;
	@UiField TextBox tbNumFebb;
	@UiField TextBox tbClub;
	@UiField ListBox cRace;
	@UiField Button bRegistration;
	@UiField Button bDelete;
	@UiField FlowPanel detailPanel;
	@UiField ControlGroup groupNameControlGroup;
	
	
	private Team team;
	private Presenter presenter;
	private Long id;
	private final RaceConstants constants = GWT.create(RaceConstants.class);

	interface TeamDetailsViewUiBinder extends UiBinder<Widget, TeamDetailsView> {
	}

	public TeamDetailsView() {
		initWidget(uiBinder.createAndBindUi(this));
		 String[] listTypes = constants.listBoxRace();
		 for (int i = 0; i < listTypes.length; i++) {
			 cRace.addItem(listTypes[i]);
		 }
		 bRegistration.addClickHandler(new ClickHandler() {

				@Override
				public void onClick(ClickEvent event) {
					presenter.saveTeam();
				}
		});
		 bDelete.addClickHandler(new ClickHandler() {

				@Override
				public void onClick(ClickEvent event) {
					presenter.delteTeam();
				}
		 });
	}

	@Override
	public void setTeam(Team team) {
		this.team = team;
		if (team == null) {
			return;
		}
		
		tbTeamName.setText(team.getTeamName());
		tbCoach.setText(team.getCoach());
		int combo = getIndexRace(team.getRace());
		cRace.setSelectedIndex(combo);
		tbNumFebb.setText(team.getNumFebb());
		tbClub.setText(team.getClub());
		
		//email.setText(team.getEmail());
		
	}

	@Override
	public Team getTeam() {
		if (team == null) {
			team = new Team();
		}
		
		team.setTeamName(tbTeamName.getText());
		team.setCoach(tbCoach.getText());
		team.setNumFebb(tbNumFebb.getText());
		team.setClub(tbClub.getText());
		team.setRace(cRace.getItemText(cRace.getSelectedIndex()));
		//team.setEmail(email.getText());
		return team;
			
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
		
	}

	@Override
	public void clear() {
		team = null;
		tbTeamName.setText("");
		tbTeamName.setStyleName("");
		tbCoach.setText("");
		tbClub.setText("");
		tbNumFebb.setText("");
		cRace.setSelectedIndex(0);
		groupNameControlGroup.setType(ControlGroupType.NONE);
		
	}
	
	
	public void panelOff() {
		detailPanel.setVisible(false);
		//detailPanel.setVisible(true);
		//detailPanel.setPixelSize(200, 200);
		
	}
	

	
	@Override
	public String getTeamEmail() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private int getIndexRace(String race){
		for(int i = 0; i < cRace.getItemCount(); i++){
			if(cRace.getItemText(i).equals(race)){
				return i;
			}
		}
		return 0;
			
	}



	public ControlGroup getGroupNameControlGroup() {
		return groupNameControlGroup;
	}

	
//	@Override
//	public void setContact(Contact contact) {
//		this.contact = contact;
//		if (contact == null) {
//			return;
//		}
//
//		title.setText(contact.getTitle());
//		name.setText(contact.getFirstName() + " " + contact.getLastName());
//		company.setText(contact.getCompany());
//		email.setText(contact.getEmail());
//
//		image.setUrl(contact.getJpegString());
//	}
//
//	@Override
//	public void setPresenter(Presenter presenter) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public String getContactEmail() {
//		return email.getText();
//	}
//
//	@Override
//	public void clear() {
//		contact = null;
//		title.setText("");
//		name.setText("");
//		company.setText("");
//		email.setText("");
//
//		image.setUrl("");
//	}
//
//	@Override
//	public Contact getContact() {
//		if (contact == null) {
//			contact = new Contact();
//		}
//
//		contact.setTitle(title.getText());
//		String[] names = name.getText().split(" ");
//		if (names.length > 0) {
//			contact.setFirstName(names[0]);
//		}
//		if (names.length > 1) {
//			contact.setLastName(names[1]);
//		}
//		if (names.length > 2) {
//			contact.setMiddleName(names[1]);
//			contact.setLastName(names[2]);
//		}
//		contact.setCompany(company.getText());
//		contact.setEmail(email.getText());
//		return contact;
//	}
}
