package org.ibertech.client.mvp;

import org.ibertech.client.IClientFactory;
import org.ibertech.client.activity.TeamListActivity;
import org.ibertech.client.place.TeamPlace;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

public class SouthActivityMapper implements ActivityMapper {

	private final IClientFactory clientFactory;

	public SouthActivityMapper(IClientFactory clientFactory) {
		super();
		this.clientFactory = clientFactory;
	}

	@Override
	public Activity getActivity(Place place) {
		if (place instanceof TeamPlace) {
			return new TeamListActivity((TeamPlace) place, clientFactory);
		}

		return null;
	}

}
