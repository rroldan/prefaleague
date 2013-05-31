package org.ibertech.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class PlayerListView extends Composite {

	private static PlayerListViewUiBinder uiBinder = GWT
			.create(PlayerListViewUiBinder.class);

	interface PlayerListViewUiBinder extends UiBinder<Widget, PlayerListView> {
	}

	public PlayerListView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}
