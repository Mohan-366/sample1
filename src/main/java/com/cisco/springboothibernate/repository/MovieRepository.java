package com.cisco.springboothibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cisco.springboothibernatedemo.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{

	Void save(Long movieId);

	

}
