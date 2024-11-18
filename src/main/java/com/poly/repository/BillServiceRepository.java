package com.poly.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.poly.model.BillService;
import com.poly.model.BillServicesId;


public interface BillServiceRepository extends JpaRepository<BillService, BillServicesId>{

}
