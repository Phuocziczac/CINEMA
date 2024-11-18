package com.poly.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.poly.model.Account;

public interface AccountRepository extends JpaRepository<Account, Integer>{
	 Page<Account> findByRoleIdIn(List<Integer> roleIds, Pageable pageable);
	 @Query("SELECT a FROM Account a WHERE " +
		       "(LOWER(a.username) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
		       "LOWER(a.email) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
		       "LOWER(a.fullname) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
		       "LOWER(a.phone) LIKE LOWER(CONCAT('%', :keyword, '%'))) AND " +
		       "(a.role.id = 1 OR a.role.id = 2)")
		List<Account> searchByKeyword(@Param("keyword") String keyword);
	 @Query("SELECT a FROM Account a WHERE " +
		       "(LOWER(a.username) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
		       "LOWER(a.email) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
		       "LOWER(a.fullname) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
		       "LOWER(a.phone) LIKE LOWER(CONCAT('%', :keyword, '%'))) AND " +
		       "(a.role.id = 3)")
		List<Account> searchByKeywordCustomer(@Param("keyword") String keyword);
 boolean existsByUsername(String username); 
	 
	 @Query("SELECT a FROM Account a WHERE a.username = :username")
	  Optional<Account> findByUsername(String username);



}
