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

package org.ibertech.client.event;

import org.ibertech.shared.Team;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

public class TeamViewEvent extends GwtEvent<TeamViewEvent.Handler> {
	public interface Handler extends EventHandler {
		void onTeamView(TeamViewEvent event);
	}

	public static final Type<TeamViewEvent.Handler> TYPE = new Type<TeamViewEvent.Handler>();

	private final Team team;

	public TeamViewEvent(Team team) {
		this.team = team;
	}

	@Override
	public final Type<TeamViewEvent.Handler> getAssociatedType() {
		return TYPE;
	}

	public Team getTeam() {
		return team;
	}

	@Override
	protected void dispatch(TeamViewEvent.Handler handler) {
		handler.onTeamView(this);
	}
}
