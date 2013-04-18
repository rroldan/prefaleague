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


public class TeamManagerTest {
	
	 public static final String CLUB = "club";
	 public static final String COACH = "coach";
	 public static final String NUMFEBB = "numFebb";
	 public static final String RACE = "race";
	 public static final String TEAM_NAME = "teamName";
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

	 @Parameters
	 public static Hashtable<String,Team> data() {
		 Hashtable<String,Team> teamFixture = new Hashtable<String,Team>();
		 Team teamOk = new Team();
		 teamOk.setClub(CLUB);
		 teamOk.setCoach(COACH);
		 teamOk.setNumFebb(NUMFEBB);
		 teamOk.setRace(RACE);
		 teamOk.setTeamName(TEAM_NAME);
		 
		 Team teamNullTeamName = new Team();
		 teamOk.setClub(CLUB);
		 teamOk.setCoach(COACH);
		 teamOk.setNumFebb(NUMFEBB);
		 teamOk.setRace(RACE);
		 
		 Team teamNullCoach = new Team();
		 teamOk.setClub(CLUB);
		 teamOk.setNumFebb(NUMFEBB);
		 teamOk.setRace(RACE);
		 teamOk.setTeamName(TEAM_NAME);
	
		 
		 teamFixture.put("teamOK",teamOk);
		 teamFixture.put("teamNullTeamName",teamNullTeamName);
		 teamFixture.put("teamNullCoach",teamNullCoach);
		 
		 return teamFixture;
	 }

	@Test
	public void testGetTeams() {		
		List<Team> teams = teamManager.getTeams();
		assertTrue(teams.isEmpty());		
		
	}
	
	@Test
	public void testSaveTeam(){
		teamManager.saveTeam(data().get("teamOK"));	
		List<Team> teams = teamManager.getTeams();
		Team  team = teams.get(0);
		assertEquals(CLUB, team.getClub());
		assertEquals(COACH, team.getCoach());
		assertEquals(NUMFEBB, team.getNumFebb());
		assertEquals(RACE, team.getRace());
		assertEquals(TEAM_NAME, team.getTeamName());

	}
	
	@Test(expected = ConstraintViolationException.class)
	public void testSaveTeamNullTeamName(){
		teamManager.saveTeam(data().get("teamNullTeamName"));	
	}
	
	@Test(expected = ConstraintViolationException.class)
	public void testSaveTeamNullCoach(){
		teamManager.saveTeam(data().get("teamNullCoach"));	
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
		Team  team = data().get("teamOK");
		teamManager.saveTeam(team);
		return team;
	}
	

}
