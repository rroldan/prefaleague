package org.ibertech.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;

public class TeamListView extends Composite implements HasText {

	private static TeamListViewUiBinder uiBinder = GWT
			.create(TeamListViewUiBinder.class);

	interface TeamListViewUiBinder extends UiBinder<Widget, TeamListView> {
	}

	public TeamListView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	
	public TeamListView(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
		
	}


	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void setText(String text) {
		// TODO Auto-generated method stub
		
	}

}
