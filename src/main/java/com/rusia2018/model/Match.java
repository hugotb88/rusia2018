package com.rusia2018.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Hugo
 * Match POJO
 */
@Entity
@Table(name="matches")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(allowGetters = true)
public class Match {
	
	//Fields
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idMatch;
	
	@Column
	private int idUser;

	@Column
	private Integer homeTeamGoals;
	
	@Column
	private Integer awayTeamGoals;
	
	@Column
	private Integer idHomeTeam;
	
	@Column
	private Integer idAwayTeam;
	
	@Column
	private LocalDateTime matchDate;
	
	@Column
	private String place;
	
	@Column
	private LocalDateTime lastUpdate;
    
    //Constructor
    public Match() {}
    
    //Constructor
	public Match(int idMatch, int idUser, Integer homeTeamGoals, Integer awayTeamGoals, Integer idHomeTeam,
			Integer idAwayTeam, LocalDateTime matchDate, String place, LocalDateTime lastUpdate) {
		super();
		this.idMatch = idMatch;
		this.idUser = idUser;
		this.homeTeamGoals = homeTeamGoals;
		this.awayTeamGoals = awayTeamGoals;
		this.idHomeTeam = idHomeTeam;
		this.idAwayTeam = idAwayTeam;
		this.matchDate = matchDate;
		this.place = place;
		this.lastUpdate = LocalDateTime.now();
	}
	
	//Getters and Setters
	public int getIdMatch() {
		return idMatch;
	}

	public void setIdMatch(int idMatch) {
		this.idMatch = idMatch;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public Integer getHomeTeamGoals() {
		return homeTeamGoals;
	}

	public void setHomeTeamGoals(Integer homeTeamGoals) {
		this.homeTeamGoals = homeTeamGoals;
	}

	public Integer getAwayTeamGoals() {
		return awayTeamGoals;
	}

	public void setAwayTeamGoals(Integer awayTeamGoals) {
		this.awayTeamGoals = awayTeamGoals;
	}

	public Integer getIdHomeTeam() {
		return idHomeTeam;
	}

	public void setIdHomeTeam(Integer idHomeTeam) {
		this.idHomeTeam = idHomeTeam;
	}

	public Integer getIdAwayTeam() {
		return idAwayTeam;
	}

	public void setIdAwayTeam(Integer idAwayTeam) {
		this.idAwayTeam = idAwayTeam;
	}

	public LocalDateTime getMatchDate() {
		return matchDate;
	}

	public void setMatchDate(LocalDateTime matchDate) {
		this.matchDate = matchDate;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public LocalDateTime getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(LocalDateTime lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
}
