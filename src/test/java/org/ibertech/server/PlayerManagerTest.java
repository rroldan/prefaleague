package org.ibertech.server;

import static org.junit.Assert.assertEquals;

import java.util.Hashtable;
import java.util.List;

import org.junit.Test;

import org.ibertech.shared.Player;
import org.ibertech.shared.Team;
import org.junit.After;
import org.junit.Before;
import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;

public class PlayerManagerTest extends Fixture {

	private final LocalServiceTestHelper helper = new LocalServiceTestHelper(
			new LocalDatastoreServiceTestConfig());

	PlayerManager playerManager;
	TeamManager teamManager;

	@Before
	public void setUp() {
		helper.setUp();
		playerManager = new PlayerManager();
		teamManager = new TeamManager();

	}

	@After
	public void tearDown() {
		helper.tearDown();
	}

	@Test
	public void testSavePlayer() {
		Player player = dataPlayer().get("playerOK");
		Team teamOk = dataTeam().get("teamOK");	
			
		teamOk.getPlayers().add(player);

		teamManager.saveTeam(teamOk);
		
	    List<Player> players = playerManager.getPlayer();
	    List<Team> teams = teamManager.getTeams();
		player = players.get(0);
		Team team = teams.get(0);
		assertEquals(PLAYER_NAME, player.getName());
		assertEquals(PLAYER_POSITION, player.getPosition());
		assertEquals(PLAYER_SKILLS, player.getSkills());
		assertEquals(team.getTeamId(),player.getTeam().getTeamId());

	}

	@Test
	public void testGetPlayers() {
		
		Player player = dataPlayer().get("playerOK");
		Team teamOk = dataTeam().get("teamOK");

		teamOk.getPlayers().add(player);
		

		teamManager.saveTeam(teamOk);
		
		
		List<Player> players = playerManager.getPlayer();
		player = players.get(0);
		
		assertEquals(PLAYER_NAME, player.getName());
		assertEquals(PLAYER_POSITION, player.getPosition());
		assertEquals(PLAYER_SKILLS, player.getSkills());

		

	}

}
