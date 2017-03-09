package io.egen.api.entity;

import java.util.List;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table

public class Movie {

	@Id
	private String id;
	@Column(unique=true)
	private String title;
	private String year;
	
	private String rated;
	private String director;
	private String released;
	private String plot;
	private String language;
	private String country;
	private String awards;
	private String poster;
	private String metaScore;
	private String imdbRating;
	private String imdbVotes;
	private String imdbid;
	private String type;
	private String Writer;

	@ManyToMany
	private List<Genre> genres;
	
	@ManyToMany
	private List<Actor> actors;
	
	

	public List<Genre> getGenres() {
		return this.genres;
	}

		public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}

	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}



	public Movie() {
		this.id = UUID.randomUUID().toString();
	}

	public String getid() {
		return id;
	}



	public void setid(String id) {
		this.id = id;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getYear() {
		return year;
	}



	public void setYear(String year) {
		this.year = year;
	}



	public String getRated() {
		return rated;
	}



	public void setRated(String rated) {
		this.rated = rated;
	}



	public String getDirector() {
		return director;
	}



	public void setDirector(String director) {
		this.director = director;
	}



	public String getReleased() {
		return released;
	}



	public void setReleased(String released) {
		this.released = released;
	}



	public String getPlot() {
		return plot;
	}



	public void setPlot(String plot) {
		this.plot = plot;
	}



	public String getLanguage() {
		return language;
	}



	public void setLanguage(String language) {
		this.language = language;
	}



	public String getCountry() {
		return country;
	}



	public void setCountry(String country) {
		this.country = country;
	}



	public String getAwards() {
		return awards;
	}



	public void setAwards(String awards) {
		this.awards = awards;
	}



	public String getPoster() {
		return poster;
	}



	public void setPoster(String poster) {
		this.poster = poster;
	}



	public String getMetaScore() {
		return metaScore;
	}



	public void setMetaScore(String metaScore) {
		this.metaScore = metaScore;
	}



	public String getImdbRating() {
		return imdbRating;
	}



	public void setImdbRating(String imdbRating) {
		this.imdbRating = imdbRating;
	}



	public String getImdbVotes() {
		return imdbVotes;
	}



	public void setImdbVotes(String imdbVotes) {
		this.imdbVotes = imdbVotes;
	}



	public String getImdbid() {
		return imdbid;
	}



	public void setImdbid(String imdbid) {
		this.imdbid = imdbid;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}


	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", year=" + year + ", rated=" + rated + ", director=" + director
				+ ", released=" + released + ", plot=" + plot + ", language=" + language + ", country=" + country
				+ ", awards=" + awards + ", poster=" + poster + ", metaScore=" + metaScore + ", imdbRating="
				+ imdbRating + ", imdbVotes=" + imdbVotes + ", imdbid=" + imdbid + ", type=" + type + ", Writer="
				 + ", genres=" + genres + ", actors=" + actors + "]";
	}
	
	
}