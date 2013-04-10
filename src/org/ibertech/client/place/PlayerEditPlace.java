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

package org.ibertech.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class PlayerEditPlace extends Place {

	private final String token;

	public PlayerEditPlace(String token) {
		this.token = token == null ? "" : token;
	}

	public String getToken() {
		return token;
	}

	public static class Tokenizer implements PlaceTokenizer<PlayerEditPlace> {

		@Override
		public String getToken(PlayerEditPlace place) {
			return place.getToken();
		}

		@Override
		public PlayerEditPlace getPlace(String token) {
			return new PlayerEditPlace(token);
		}

	}
}
