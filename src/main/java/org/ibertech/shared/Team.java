package org.ibertech.shared; 

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.datanucleus.api.jpa.annotations.Extension;
import org.hibernate.validator.constraints.NotEmpty;

import com.google.appengine.api.datastore.Key;
 
@Entity
public class Team implements Serializable{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Key teamId;
	@NotEmpty (message = "No puede ser blanco.")
//	@Size (min = 1, message = "No puede ser blanco.")
	private String teamName;
	@NotEmpty (message = "No puede ser blanco.")
	private String coach;
	private String race;
	private String numFebb;
	private String club;
	
	@OneToMany(mappedBy = "team",cascade = CascadeType.ALL)
	private List<Player> players = new ArrayList<Player>();
 
	
	public Key getTeamId(){
		return teamId;
	}
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
	
	public List<Player> getPlayers() {
	    return players;
	  }
	
	@Override
	public String toString() {
		return "Team [teamName=" + teamName + ", coach=" + coach + ", race="
				+ race + " Nº FEBB="+ numFebb + " club=" + club + "]";
	}
	
	

}
