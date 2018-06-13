package com.rusia2018.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Hugo
 * Match POJO
 */
@Entity(name="user_matches")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(allowGetters = true)
public class UserMatches {
	
	//Fields
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idUserMatches;
	
	@Column
	private Long idUser;
	
	@Column
	private String name;
	
	@Column
	private String type;
	
	@Column
	private Integer home_team;
	
	@Column
	private Integer away_team;
	
	@Column
	private Integer home_result;
	
	@Column
	private Integer away_result;
	
	@Column
	private String date;

	@Column
	private Integer matchday;
	
	
    //Constructor
    public UserMatches() {}

    //Constructor
	public UserMatches(Long idUserMatches, Long idUser, String name, String type, Integer home_team,
			Integer away_team, Integer home_result, Integer away_result, String date, Integer matchday) {
		this.idUserMatches = idUserMatches;
		this.idUser = idUser;
		this.name = name;
		this.type = type;
		this.home_team = home_team;
		this.away_team = away_team;
		this.home_result = home_result;
		this.away_result = away_result;
		this.date = date;
		this.matchday = matchday;
	}

	//Getters and Setters
	public Long getIdUserMatches() {
		return idUserMatches;
	}

	public void setIdUserMatches(Long idUserMatches) {
		this.idUserMatches = idUserMatches;
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getHome_team() {
		return home_team;
	}

	public void setHome_team(Integer home_team) {
		this.home_team = home_team;
	}

	public Integer getAway_team() {
		return away_team;
	}

	public void setAway_team(Integer away_team) {
		this.away_team = away_team;
	}

	public Integer getHome_result() {
		return home_result;
	}

	public void setHome_result(Integer home_result) {
		this.home_result = home_result;
	}

	public Integer getAway_result() {
		return away_result;
	}

	public void setAway_result(Integer away_result) {
		this.away_result = away_result;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Integer getMatchday() {
		return matchday;
	}

	public void setMatchday(Integer matchday) {
		this.matchday = matchday;
	}
	
}
