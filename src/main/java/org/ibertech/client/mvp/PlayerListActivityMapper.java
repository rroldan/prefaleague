package org.ibertech.client.mvp;

import org.ibertech.client.IClientFactory;
import org.ibertech.client.activity.PlayerListActivity;
import org.ibertech.client.activity.TeamListActivity;
import org.ibertech.client.place.PlayerPlace;
import org.ibertech.client.place.TeamPlace;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

public class PlayerListActivityMapper  implements ActivityMapper {

	private final IClientFactory clientFactory;

	public PlayerListActivityMapper(IClientFactory clientFactory) {
		super();
		this.clientFactory = clientFactory;
	}

	
	public Activity getActivity(Place place) {
		if (place instanceof PlayerPlace) {
			return new PlayerListActivity((PlayerPlace) place, clientFactory);
		}

		return null;
	}

}
