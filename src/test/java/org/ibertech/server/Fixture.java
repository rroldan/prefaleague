package org.ibertech.server;

import java.util.Hashtable;

import org.ibertech.shared.Player;
import org.ibertech.shared.Team;
import org.junit.runners.Parameterized.Parameters;

public class Fixture implements IFixture {

	@Parameters
	 public static Hashtable<String,Team> dataTeam() {
		 Hashtable<String,Team> teamFixture = new Hashtable<String,Team>();
		 Team teamOk = new Team();
		 teamOk.setClub(TEAM_CLUB);
		 teamOk.setCoach(TEAM_COACH);
		 teamOk.setNumFebb(TEAM_NUMFEBB);
		 teamOk.setRace(TEAM_RACE);
		 teamOk.setTeamName(TEAM_TEAM_NAME);
		 
		 Team teamNullTeamName = new Team();
		 teamOk.setClub(TEAM_CLUB);
		 teamOk.setCoach(TEAM_COACH);
		 teamOk.setNumFebb(TEAM_NUMFEBB);
		 teamOk.setRace(TEAM_RACE);
		 
		 Team teamNullCoach = new Team();
		 teamOk.setClub(TEAM_CLUB);
		 teamOk.setNumFebb(TEAM_NUMFEBB);
		 teamOk.setRace(TEAM_RACE);
		 teamOk.setTeamName(TEAM_TEAM_NAME);
	
		 
		 teamFixture.put("teamOK",teamOk);
		 teamFixture.put("teamNullTeamName",teamNullTeamName);
		 teamFixture.put("teamNullCoach",teamNullCoach);
		 
		 return teamFixture;
	 }
	
	@Parameters
	 public static Hashtable<String,Player> dataPlayer() {
		 Hashtable<String,Player> playerFixture = new Hashtable<String,Player>();
		 
		 Player playerOk = new Player();
		  
		 playerOk.setName(PLAYER_NAME);
		 playerOk.setPosition(PLAYER_POSITION);
		 playerOk.setSkills(PLAYER_SKILLS);
		 
		 	 
		 playerFixture.put("playerOK",playerOk);
		 return playerFixture;
	 }
	 

}
