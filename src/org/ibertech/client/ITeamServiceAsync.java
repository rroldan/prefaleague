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

package org.ibertech.client;

import java.util.List;

import org.ibertech.shared.Team;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ITeamServiceAsync {

	void getAllTeam(AsyncCallback<List<Team>> callback);

	void getTeam(String email, AsyncCallback<Team> callback);

	void addTeam(Team team, AsyncCallback<Void> callback);

	void saveTeam(Team team, AsyncCallback<Void> callback);

	void deleteTeam(Team team, AsyncCallback<Void> callback);

}
