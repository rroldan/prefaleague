package org.ibertech.client.mvp;

import org.ibertech.client.IClientFactory;
import org.ibertech.client.activity.PlayerDetailsActivity;
import org.ibertech.client.place.PlayerEditPlace;
import org.ibertech.client.place.PlayerPlace;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

public class PlayerDetailsActivityMapper implements ActivityMapper {

	private final IClientFactory clientFactory;

	public PlayerDetailsActivityMapper(IClientFactory clientFactory) {
		super();
		this.clientFactory = clientFactory;
	}

	@Override
	public Activity getActivity(Place place) {
		if (place instanceof PlayerPlace) {
			return new PlayerDetailsActivity((PlayerPlace) place, clientFactory);
		} else if (place instanceof PlayerEditPlace) {
			return new PlayerDetailsActivity((PlayerEditPlace) place, clientFactory);
		}

		return null;
	}


}
