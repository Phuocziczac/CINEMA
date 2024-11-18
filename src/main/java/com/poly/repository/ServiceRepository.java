package com.poly.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poly.model.Service;

public interface ServiceRepository extends JpaRepository<Service, Integer> {
	List<Service> findByNameContainingIgnoreCase(String keyword);
}
