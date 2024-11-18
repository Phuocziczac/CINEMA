package com.poly.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poly.model.payment_method;

public interface PayMethodRepository extends JpaRepository<payment_method, Integer> {

}
