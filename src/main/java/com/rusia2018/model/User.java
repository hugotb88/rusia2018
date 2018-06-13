package com.rusia2018.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;

import org.springframework.data.annotation.Transient;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author victor olvera
 * User POJO
 */
@Entity(name="users")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(allowGetters = true)
public class User {
	
	//Fields
	@Id
	private Long idUser;
	
	@Column
	private String firstName;

	@Column
	private String lastName;
	
	@Column
	private String email;
	
	@Column
	private String profilePicture;
	
	@Column
	private Integer totalScore;
    
	@Column
	private Boolean paid;
	
	@Transient
	private ArrayList<UserMatches> matches;
	
	
    //Constructor
    public User() {}

    //Constructor
	public User(Long idUser, String firstName, String lastName, String email, String profilePicture,
			Integer totalScore, Boolean paid) {
		this.idUser = idUser;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.profilePicture = profilePicture;
		this.totalScore = totalScore;
		this.paid = paid;
	}
	
	
	//Methods
	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}

	public Integer getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(Integer totalScore) {
		this.totalScore = totalScore;
	}

	public Boolean getPaid() {
		return paid;
	}

	public void setPaid(Boolean paid) {
		this.paid = paid;
	}

	public ArrayList<UserMatches> getMatches() {
		return matches;
	}

	public void setMatches(ArrayList<UserMatches> matches) {
		this.matches = matches;
	}
    
	
}
