package org.ibertech.client.mvp;


import org.ibertech.client.IClientFactory;
import org.ibertech.client.IShowcaseActivity;
import org.ibertech.client.activity.TeamNavbarActivity;
import org.ibertech.client.place.TeamPlace;
import org.ibertech.client.place.PlayerPlace;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.Place;


public class NorthActivityMapper implements ActivityMapper {

	private final IClientFactory clientFactory;

	public NorthActivityMapper(IClientFactory clientFactory) {
		super();
		this.clientFactory = clientFactory;
	}

	
	public Activity getActivity(Place place) {
		
		
		if (place instanceof TeamPlace) {
			return new TeamNavbarActivity((TeamPlace) place, clientFactory);
		}

        if (place instanceof PlayerPlace) {
            return new TeamNavbarActivity((PlayerPlace) place, clientFactory);
        }
        return null;
  }		
	
	
}
