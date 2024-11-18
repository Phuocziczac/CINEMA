package com.poly.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;

import jakarta.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Seats", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"Room_ID", "RowNumber", "SeatNumber"})
})
public class Seat implements Serializable {
  
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "RowNumber", nullable = false)
    private String rowNumber;
    
    @Column(name = "SeatNumber", nullable = false)
    private int seatNumber;
    
    @Column(name = "Status", nullable = false)
    private boolean status;
    
  

    @Column(name = "BookingLockTime")
    private java.sql.Time bookingLockTime;

    @ManyToOne
    @JoinColumn(name = "Room_ID", nullable = false)
    private Room room;

    @ManyToOne
    @JoinColumn(name = "SeatClass_ID", nullable = false)
    private SeatClass seatClass;

	public Seat(int id, String rowNumber, boolean status) {
		super();
		this.id = id;
		this.rowNumber = rowNumber;
		this.status = status;
	}
    
    
}
