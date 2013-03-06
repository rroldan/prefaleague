package org.ibertech.client.mvp;

import org.ibertech.client.IClientFactory;
import org.ibertech.client.activity.TeamDetailsActivity;
import org.ibertech.client.place.TeamEditPlace;
import org.ibertech.client.place.TeamPlace;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

public class CenterActivityMapper implements ActivityMapper {

	private final IClientFactory clientFactory;

	public CenterActivityMapper(IClientFactory clientFactory) {
		super();
		this.clientFactory = clientFactory;
	}

	@Override
	public Activity getActivity(Place place) {
		if (place instanceof TeamPlace) {
			return new TeamDetailsActivity((TeamPlace) place, clientFactory);
		} else if (place instanceof TeamEditPlace) {
			return new TeamDetailsActivity((TeamEditPlace) place, clientFactory);
		}

		return null;
	}

}
