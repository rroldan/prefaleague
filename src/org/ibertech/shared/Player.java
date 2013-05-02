package org.ibertech.shared;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.datanucleus.api.jpa.annotations.Extension;
import org.hibernate.validator.constraints.NotEmpty;

import com.google.appengine.api.datastore.Key;

@Entity
public class Player implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Key playerId;
	
	
	@NotEmpty (message = "No puede ser blanco.")
	private String name;
	private String position;
	private String skills;
	

	@ManyToOne(fetch = FetchType.LAZY)
	private Team team;
	
	public Key getPlayerId() {
		return playerId;
	}

	public String getName() { 
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

   public Team getTeam() {
		return team;
   }

   public void setTeam(Team team) {
		this.team = team;
   }

	  
	  
}
