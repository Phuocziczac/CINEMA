package com.poly.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poly.model.BillSeats;
import com.poly.model.BillSeatsId;



public interface BillSeatRepository extends JpaRepository<BillSeats, BillSeatsId> {

}
