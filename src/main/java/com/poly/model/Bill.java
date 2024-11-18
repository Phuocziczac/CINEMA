package com.poly.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Bill")
public class Bill implements Serializable{
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;

	    // Relationship with Account
	    @ManyToOne
	    @JoinColumn(name = "Account_ID", nullable = false)
	    private Account account;

	    // Relationship with Movie
	    @ManyToOne
	    @JoinColumn(name = "Movie_ID",nullable = true)
	    private Movie movie;

	    // Relationship with Room
	    @ManyToOne
	    @JoinColumn(name = "Room_ID",nullable = true)
	    private Room room;

	    // Relationship with Schedule
	    @ManyToOne
	    @JoinColumn(name = "Schedule_ID",nullable = true)
	    private Schedule schedule;

	    // Relationship with PaymentMethod
	    @ManyToOne
	    @JoinColumn(name = "Payment_method_ID", nullable = false)
	    private payment_method paymentMethod;

	    @Column(name = "Total_price", nullable = false)
	    private BigDecimal totalPrice;

	    @Column(name = "Status", nullable = false)
	    private boolean status;

	    @Column(name = "Created_at", nullable = false)
	    private java.sql.Timestamp createdAt;
	
}
