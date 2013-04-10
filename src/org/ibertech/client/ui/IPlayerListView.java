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

import java.util.List;

import org.ibertech.shared.Player;
import org.ibertech.shared.Team;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.IsWidget;

public interface IPlayerListView extends IsWidget, AcceptsOneWidget {
	public interface Presenter {
		void goTo(Place place);

		void select(int index);

		void select(Team team);
	}

	void setPresenter(Presenter presenter);

	void selectInitialRow(int i);

	void selectInitialTeam(Player player);

	void initialize(List<Player> player);
}
