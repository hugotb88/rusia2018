package com.rusia2018.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author victor olvera
 * User POJO
 */
@Entity
@Table(name="user")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(allowGetters = true)
public class User {
	
	//Fields
	@Id
	private Integer idUser;
	
	@Column
	private Integer score;

	@Column
	private Boolean paid;
	
	@Column
	private LocalDateTime creationDate;
    
    
    //Constructor
    public User() {}
    
    //Constructor
    public User(Integer idUser, Integer score, Boolean paid){
        this.idUser = idUser;
        this.score = score;
        this.paid = paid;
        this.creationDate = LocalDateTime.now();
    }
    
    
    //Methods
	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Boolean getPaid() {
		return paid;
	}

	public void setPaid(Boolean paid) {
		this.paid = paid;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}
}
