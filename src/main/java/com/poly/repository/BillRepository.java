package com.poly.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poly.model.Bill;

public interface BillRepository extends JpaRepository<Bill, Integer> {

}
