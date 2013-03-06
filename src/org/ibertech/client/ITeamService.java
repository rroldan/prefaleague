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

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;


@RemoteServiceRelativePath("team")
public interface ITeamService extends RemoteService {
	List<Team> getAllTeam() throws IllegalArgumentException;

	Team getTeam(String email) throws IllegalArgumentException;

	void addTeam(Team team);

	void deleteTeam(Team team);

	void saveTeam(Team team);
}
