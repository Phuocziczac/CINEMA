package com.poly.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.poly.model.Room;

public interface RoomRepository extends JpaRepository<Room, Integer> {
	@Query("select r from Room r where LOWER(r.name) LIKE LOWER(CONCAT('%', :keyword, '%'))")
	List<Room> searchByKeyword(@Param("keyword") String keyword);

}
