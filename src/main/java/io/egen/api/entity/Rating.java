package io.egen.api.entity;

import java.util.List;
import java.util.UUID;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table

public class Rating {
	@ManyToOne
	private User usr;
	@ManyToOne
	private Movie mve;
	@Id
	private String id;
	private int rating;
	
	public Rating(){
		this.id=UUID.randomUUID().toString();
	}
	
	public User getUsr() {
		return usr;
	}
	public void setUsr(User usr) {
		this.usr = usr;
	}
	public Movie getMve() {
		return mve;
	}
	public void setMve(Movie mve) {
		this.mve = mve;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	
}

