package org.ibertech.shared;

import java.io.Serializable;

@SuppressWarnings("serial")
public class TeamOld implements Serializable{
	private String teamName = "";
	private String coach = "";
	private String race = "";
	private String numFebb = "";
	private String club = "";
	
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getCoach() {
		return coach;
	}
	public void setCoach(String coach) {
		this.coach = coach;
	}
	public String getRace() {
		return race;
	}
	public void setRace(String race) {
		this.race = race;
	}
	public String getNumFebb() {
		return numFebb;
	}
	public void setNumFebb(String numFebb) {
		this.numFebb = numFebb;
	}
	public String getClub() {
		return club;
	}
	public void setClub(String club) {
		this.club = club;
	}
	@Override
	public String toString() {
		return "Team [teamName=" + teamName + ", coach=" + coach + ", race="
				+ race + " Nº FEBB="+ numFebb + " club=" + club + "]";
	}
	
	

}
