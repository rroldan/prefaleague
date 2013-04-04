package org.ibertech.client.activity;

public class ActivityRegistry {
	private static TeamDetailsActivity teamDetailsActivity;
	private static TeamListActivity teamListActivity;
    private static TeamNavbarActivity teamNavBarActivity;

	public static TeamDetailsActivity getTeamDetailsActivity() {
		return teamDetailsActivity;
	}

	public static void setTeamDetailsActivity(TeamDetailsActivity teamDetailsActivity) {
		ActivityRegistry.teamDetailsActivity = teamDetailsActivity;
	}

	public static void setTeamListActivity(TeamListActivity teamListActivity) {
		ActivityRegistry.teamListActivity = teamListActivity;
	}

	public static TeamNavbarActivity getTeamNavbarActivity() {
		return teamNavBarActivity;
	}

    public static void setToolbarActivity(TeamNavbarActivity teamNavbarActivity) {
    	ActivityRegistry.teamNavBarActivity = teamNavbarActivity;
	}
}
