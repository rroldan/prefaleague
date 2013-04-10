package org.ibertech.client.ui;

import org.ibertech.shared.Player;

import com.github.gwtbootstrap.client.ui.ControlGroup;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class PlayerDetailsView extends Composite implements IPlayerDetailsView {

	private static PlayerDetailsUiBinder uiBinder = GWT
			.create(PlayerDetailsUiBinder.class);

	interface PlayerDetailsUiBinder extends UiBinder<Widget, PlayerDetailsView> {
	}

	public PlayerDetailsView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void setPlayer(Player player) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Player getPlayer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPresenter(Presenter presenter) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ControlGroup getGroupNameControlGroup() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTeamEmail() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void panelOff() {
		// TODO Auto-generated method stub
		
	}

}
