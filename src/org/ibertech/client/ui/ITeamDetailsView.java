package org.ibertech.client.ui;

import org.ibertech.shared.Team;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;
import org.ibertech.client.ui.ITeamDetailsView.Presenter;

public interface ITeamDetailsView extends IsWidget {

	void setTeam(Team team);

	Team getTeam();

	void setPresenter(Presenter presenter);

	void clear();

	String getTeamEmail();

	public interface Presenter {
		void goTo(Place place);

		Team getTeam();

		void saveTeam();
		
		void delteTeam();
	}
}
