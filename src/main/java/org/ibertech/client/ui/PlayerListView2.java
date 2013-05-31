package org.ibertech.client.ui;

import java.util.List;

import org.ibertech.shared.Player;
import org.ibertech.shared.Team;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;

public class PlayerListView2 extends Composite implements IPlayerListView {

	private static PlayerListView2UiBinder uiBinder = GWT
			.create(PlayerListView2UiBinder.class);

	interface PlayerListView2UiBinder extends UiBinder<Widget, PlayerListView2> {
	}

	public PlayerListView2() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	
	public void setWidget(IsWidget w) {
		// TODO Auto-generated method stub
		
	}

	
	public void setPresenter(Presenter presenter) {
		// TODO Auto-generated method stub
		
	}

	
	public void selectInitialRow(int i) {
		// TODO Auto-generated method stub
		
	}

	
	public void selectInitialTeam(Player player) {
		// TODO Auto-generated method stub
		
	}

	
	public void initialize(List<Player> player) {
		// TODO Auto-generated method stub
		
	}

	
}
