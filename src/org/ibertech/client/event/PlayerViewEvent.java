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

import org.ibertech.shared.Player;
import org.ibertech.shared.Team;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

public class PlayerViewEvent extends GwtEvent<PlayerViewEvent.Handler> {
	public interface Handler extends EventHandler {
		void onPlayerView(PlayerViewEvent event);
	}

	public static final Type<PlayerViewEvent.Handler> TYPE = new Type<PlayerViewEvent.Handler>();

	private final Player player;

	public PlayerViewEvent(Player player) {
		this.player = player;
	}

	@Override
	public final Type<PlayerViewEvent.Handler> getAssociatedType() {
		return TYPE;
	}

	public Player getPlayer() {
		return player;
	}

	@Override
	protected void dispatch(PlayerViewEvent.Handler handler) {
		handler.onPlayerView(this);
	}
}
