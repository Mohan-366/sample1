package com.cisco.springboothibernatedemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Movie {
	@Id
	@Column(name = "movieid")
	private long movieID;
	@Column(name ="moviename")
    private String movieName;
	@Column(name = "movierating")
	private int movieRating;
	
	public Movie(){
		//todo auto-genereate constructor stub
	}
	
	public Movie(long movieID, String movieName, int movieRating) {
		super();
		this.movieID = movieID;
		this.movieName = movieName;
		this.movieRating = movieRating;
	}

	public long getMovieID() {
		return movieID;
	}

	public void setMovieID(long movieID) {
		this.movieID = movieID;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public int getMovieRating() {
		return movieRating;
	}

	public void setMovieRating(int movieRating) {
		this.movieRating = movieRating;
	}
	
	
}
