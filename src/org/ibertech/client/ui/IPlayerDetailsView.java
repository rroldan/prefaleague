package org.ibertech.client.ui;

import org.ibertech.shared.Player;
import org.ibertech.shared.Team;

import com.github.gwtbootstrap.client.ui.ControlGroup;
import com.github.gwtbootstrap.client.ui.TextBox;
import com.github.gwtbootstrap.client.ui.constants.ControlGroupType;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;

import org.ibertech.client.ui.IPlayerDetailsView.Presenter;

public interface IPlayerDetailsView extends IsWidget {

	void setPlayer(Player player);

	Player getPlayer();

	void setPresenter(Presenter presenter);

	void clear();
	
	ControlGroup getGroupNameControlGroup();
	
	String getTeamEmail();
	
	void panelOff();

	public interface Presenter {
		void goTo(Place place);

		Player getPlayer();

		void savePlayer();
		
		void deltePlayer();
		
	}
}
