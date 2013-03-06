package org.ibertech.client.activity;

public class ActivityRegistry {
	private static TeamDetailsActivity teamDetailsActivity;
	private static TeamListActivity teamListActivity;
	//private static ToolBarActivity ToolbarActivity;

	public static TeamDetailsActivity getTeamDetailsActivity() {
		return teamDetailsActivity;
	}

	public static void setTeamDetailsActivity(TeamDetailsActivity teamDetailsActivity) {
		ActivityRegistry.teamDetailsActivity = teamDetailsActivity;
	}

//	public static ContactListActivity getContactListActivity() {
//		return contactListActivity;
//	}
//
	public static void setTeamListActivity(TeamListActivity teamListActivity) {
		ActivityRegistry.teamListActivity = teamListActivity;
	}
//
//	public static ToolBarActivity getToolbarActivity() {
//		return ToolbarActivity;
//	}
//
//	public static void setToolbarActivity(ToolBarActivity toolbarActivity) {
//		ToolbarActivity = toolbarActivity;
//	}
}
