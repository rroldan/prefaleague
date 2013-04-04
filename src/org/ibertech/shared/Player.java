package org.ibertech.shared;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Player {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long playerId;
	
	
	@NotEmpty (message = "No puede ser blanco.")
	private String name;
	private String position;
	private String skills;
	
	@NotEmpty (message = "No puede haber jugador sin equipo")
	private Team team;
	
	public Long getPlayerId() {
		return playerId;
	}

	
	@ManyToOne
	  public Team getFamily() {
	    return team;
	  }

	
	
	public void setFamily(Team team) {
	    this.team = team;
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
