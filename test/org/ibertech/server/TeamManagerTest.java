package org.ibertech.server;


import static org.junit.Assert.*;

import java.util.Hashtable;
import java.util.List;

import javax.validation.ConstraintViolationException;

import org.ibertech.shared.Team;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized.Parameters;
import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;


public class TeamManagerTest extends Fixture {
	
	 
	 public static final int ZERO = 0;
	 
	 private final LocalServiceTestHelper helper =
		        new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());
	
	TeamManager teamManager;
	
	@Before
    public void setUp() {
		helper.setUp();
		teamManager = new TeamManager();
		
    }
	
	 @After
	    public void tearDown() {
	        helper.tearDown();
	    }

	 

	@Test
	public void testGetTeams() {		
		List<Team> teams = teamManager.getTeams();
		assertTrue(teams.isEmpty());		
		
	}
	
	@Test
	public void testSaveTeam(){
		teamManager.saveTeam(dataTeam().get("teamOK"));	
		List<Team> teams = teamManager.getTeams();
		Team  team = teams.get(0);
		assertEquals(TEAM_CLUB, team.getClub());
		assertEquals(TEAM_COACH, team.getCoach());
		assertEquals(TEAM_NUMFEBB, team.getNumFebb());
		assertEquals(TEAM_RACE, team.getRace());
		assertEquals(TEAM_TEAM_NAME, team.getTeamName());

	}
	
	@Test(expected = ConstraintViolationException.class)
	public void testSaveTeamNullTeamName(){
		teamManager.saveTeam(dataTeam().get("teamNullTeamName"));	
	}
	
	@Test(expected = ConstraintViolationException.class)
	public void testSaveTeamNullCoach(){
		teamManager.saveTeam(dataTeam().get("teamNullCoach"));	
	}
	
	@Test
	public void testDeleteTeam(){
		Team team = addTeam();
		
		teamManager.deleteTeam(team);
		
		List<Team> teamsVerify = teamManager.getTeams();
		assertTrue(teamsVerify.isEmpty());	
	}
	
	@Test 
	public void testGetTeamIndex(){
		Team team = addTeam();
		
		int index = teamManager.getTeamIndex(team);
		
		assertTrue(ZERO == index);
		
	}
	
	private Team addTeam(){
		Team  team = dataTeam().get("teamOK");
		teamManager.saveTeam(team);
		return team;
	}
	

}
