package com.poly.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poly.model.Showtime;

public interface ShowtimeRepository extends JpaRepository<Showtime, Integer> {

}
