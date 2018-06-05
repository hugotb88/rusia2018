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
 * Team POJO
 */
@Entity
@Table(name="team")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(allowGetters = true)
public class Team {
	
	//Fields
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idTeam;
	
	@Column
	private String teamName;

	@Column
	private char group;
	
	@Column
	private String flagIcon;
	
	@Column
	private Boolean r16;
	
	@Column
	private Boolean quarter;
	
	@Column
	private Boolean semi;
	
	@Column
	private Boolean finals;
	
	@Column
	private Boolean third;
	
	
    
    //Constructor
    public Team() {}
    
    //Constructor
    public Team(Integer idTeam, String teamName, char group, String flagIcon, Boolean r16, Boolean quarter,
			Boolean semi, Boolean finals, Boolean third) {
		this.idTeam = idTeam;
		this.teamName = teamName;
		this.group = group;
		this.flagIcon = flagIcon;
		this.r16 = r16;
		this.quarter = quarter;
		this.semi = semi;
		this.finals = finals;
		this.third = third;
	}
    
    
    //Getters and Setters
	public Integer getIdTeam() {
		return idTeam;
	}

	public void setIdTeam(Integer idTeam) {
		this.idTeam = idTeam;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public char getGroup() {
		return group;
	}

	public void setGroup(char group) {
		this.group = group;
	}

	public String getFlagIcon() {
		return flagIcon;
	}

	public void setFlagIcon(String flagIcon) {
		this.flagIcon = flagIcon;
	}

	public Boolean getR16() {
		return r16;
	}

	public void setR16(Boolean r16) {
		this.r16 = r16;
	}

	public Boolean getQuarter() {
		return quarter;
	}

	public void setQuarter(Boolean quarter) {
		this.quarter = quarter;
	}

	public Boolean getSemi() {
		return semi;
	}

	public void setSemi(Boolean semi) {
		this.semi = semi;
	}

	public Boolean getFinals() {
		return finals;
	}

	public void setFinals(Boolean finals) {
		this.finals = finals;
	}

	public Boolean getThird() {
		return third;
	}

	public void setThird(Boolean third) {
		this.third = third;
	}
    
}
