package com.cisco.springboothibernatedemo.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cisco.springboothibernate.repository.MovieRepository;
import com.cisco.springboothibernatedemo.entity.Movie;

@RestController
public class MovieController {
	@Autowired //Spring's dependency injection facilities
	private MovieRepository movieRepo;

	@GetMapping("getallmovies")
	public List<Movie> getAllMovies(){
		return movieRepo.findAll();//select * from movie;
	}
	@PostMapping("/insertmovie")
	public Movie insterMovie(@RequestBody Movie mv) {
		return movieRepo.save(mv);//insert into movie values (?,?,?);
	}
	@GetMapping("/getmoviebyid/{movid}")
	public Movie getMovieById(@PathVariable("movid")Long movieId) {
		return movieRepo.findById(movieId).get();
		//select*from movie where movieid = ?;
	}
	//@requestMapping("/getmoviebyid/{movid}")
	//public Movie requestMovieById(@PathVariable("movid")Long movieId) {
		//return movieRepo.findById(movieId).get();
	//}
   @DeleteMapping("/deletemoviebyid/{movid}")
   public Void DeleteMovieById(@PathVariable("movid")Long movieId) {
	   movieRepo.deleteById(movieId);;//
return movieRepo.save(movieId);
   }
	@PutMapping("/updatemoviebyid/{movid}")
	public Movie updateMoiveById(@PathVariable("movid")Long movieId,@RequestBody Movie mv) {
		Movie existingMovie = getMovieById(movieId);
		existingMovie.setMovieID(mv.getMovieID());
		existingMovie.setMovieRating(mv.getMovieRating());
		existingMovie.setMovieName(mv.getMovieName());
		return movieRepo.save(existingMovie);
		
	
}
}