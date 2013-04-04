package org.ibertech.client.ui;

import org.ibertech.shared.Team;

import com.github.gwtbootstrap.client.ui.ControlGroup;
import com.github.gwtbootstrap.client.ui.TextBox;
import com.github.gwtbootstrap.client.ui.constants.ControlGroupType;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;

import org.ibertech.client.ui.ITeamDetailsView.Presenter;

public interface ITeamDetailsView extends IsWidget {

	void setTeam(Team team);

	Team getTeam();

	void setPresenter(Presenter presenter);

	void clear();
	
	ControlGroup getGroupNameControlGroup();
	
	String getTeamEmail();
	
	void panelOff();

	public interface Presenter {
		void goTo(Place place);

		Team getTeam();

		void saveTeam();
		
		void delteTeam();
		
	}
}
