package io.egen.api.entity;

import java.util.UUID;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table

public class Comment {

	@Id
	private String id;
	private String comment;
	
	@ManyToOne
	private User usr;
	
	@ManyToOne
	private Movie mve;
	
	public User getUsr() {
		return usr;
	}
	public void setUsr(User usr) {
		this.usr = usr;
	}
	public Movie getmve() {
		return mve;
	}
	public void setmve(Movie mve) {
		this.mve = mve;
	}
	
	public Comment(){
		this.id= UUID.randomUUID().toString();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
}

