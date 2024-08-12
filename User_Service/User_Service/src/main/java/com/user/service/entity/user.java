package com.user.service.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "micro_user")
public class user {

	public List<Rating> getRatings() {
		return ratings;
	}


	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "uid")
	private String id;
	
	@Column(name = "uname",length = 20)
	private String name;
	
	@Column(name = "uemail")
	private String email;
	
	@Column(name = "uabout")
	private String about;
	
	@Transient
	private List<Rating> ratings = new ArrayList<>();
	

	public user(String id, String name, String email, String about) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.about = about;
	}
	

	public user() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}
	
}
