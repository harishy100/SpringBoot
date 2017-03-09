package io.egen.api.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Genre {


	@Id
	private String genreName;
	
	public Genre() {
		this.genreName = "";
	}
	
	public Genre(String genrename) {
		this.genreName = genrename;
	}

	public String getGenrename() {
		return this.genreName;
	}

	public void setGenrename(String genrename) {
		this.genreName = genrename;
	}
	
	
}
