package org.ibertech.client.activity;

public class ActivityRegistry {
	private static TeamDetailsActivity teamDetailsActivity;
	private static TeamListActivity teamListActivity;
    private static TeamNavbarActivity teamNavBarActivity;
    private static PlayerListActivity playerListActivity;
    private static PlayerDetailsActivity playerDetailsActivity;

	public static PlayerDetailsActivity getPlayerDetailsActivity() {
		return playerDetailsActivity;
	}

	public static void setPlayerDetailsActivity(
			PlayerDetailsActivity playerDetailsActivity) {
		ActivityRegistry.playerDetailsActivity = playerDetailsActivity;
	}

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
    
    public static PlayerListActivity getPlayerListActivity() {
		return playerListActivity;
	}

    public static void setPlayerListActivity(PlayerListActivity playerListActivity) {
    	ActivityRegistry.playerListActivity = playerListActivity;
	}
}
