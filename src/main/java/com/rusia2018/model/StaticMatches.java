package com.rusia2018.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.annotation.Transient;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Hugo
 * Static Matches POJO
 */
@Entity(name="static_matches")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(allowGetters = true)
public class StaticMatches {
	
	//Fields
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idStaticMatches;
	
	@Column
	private Integer name;
	
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
	private LocalDateTime date;
	
	@Column
	private Boolean finished;
	
	
    
    //Constructor
    public StaticMatches() {}

    //Constructor
	public StaticMatches(Long idStaticMatches, Integer name, String type, Integer home_team, Integer away_team,
			Integer home_result, Integer away_result, LocalDateTime date, Boolean finished) {
		this.idStaticMatches = idStaticMatches;
		this.name = name;
		this.type = type;
		this.home_team = home_team;
		this.away_team = away_team;
		this.home_result = home_result;
		this.away_result = away_result;
		this.date = date;
		this.finished = finished;
	}
	
	//Getters and Setters
	public Long getIdStaticMatches() {
		return idStaticMatches;
	}

	public void setIdStaticMatches(Long idStaticMatches) {
		this.idStaticMatches = idStaticMatches;
	}

	public Integer getName() {
		return name;
	}

	public void setName(Integer name) {
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

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public Boolean getFinished() {
		return finished;
	}

	public void setFinished(Boolean finished) {
		this.finished = finished;
	}

	
}
