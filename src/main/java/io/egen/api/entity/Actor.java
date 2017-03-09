package io.egen.api.entity;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table
public class Actor {

	@Id
	private String actorName;
	
	public Actor(){
		this.actorName = "";
	}
	
	public Actor(String actorname){
		this.actorName = actorname;
	}
	
	public String getActorname() {
		return actorName;
	}

	public void setActorname(String actorname) {
		this.actorName = actorname;
	}
	
}