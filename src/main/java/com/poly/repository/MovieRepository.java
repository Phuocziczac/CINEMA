package com.poly.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poly.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer>{

}
