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
 * Team POJO
 */
@Entity(name="teams")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(allowGetters = true)
public class Team {
	
	//Fields
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column
	private String name;
	
	@Column
	private String fifacode;
	
	@Column
	private String iso2;
	
	@Column
	private String flag;
	
	@Column
	private String emoji;
	
	@Column
	private String emojiString;
	
    
    //Constructor
    public Team() {}

    //Constructor
	public Team(Integer id, String name, String fifacode, String iso2, String flag, String emoji, String emojiString) {
		this.id = id;
		this.name = name;
		this.fifacode = fifacode;
		this.iso2 = iso2;
		this.flag = flag;
		this.emoji = emoji;
		this.emojiString = emojiString;
	}
	
	
	//Getters and Setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFifacode() {
		return fifacode;
	}

	public void setFifacode(String fifacode) {
		this.fifacode = fifacode;
	}

	public String getIso2() {
		return iso2;
	}

	public void setIso2(String iso2) {
		this.iso2 = iso2;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getEmoji() {
		return emoji;
	}

	public void setEmoji(String emoji) {
		this.emoji = emoji;
	}

	public String getEmojiString() {
		return emojiString;
	}

	public void setEmojiString(String emojiString) {
		this.emojiString = emojiString;
	}
    
}
