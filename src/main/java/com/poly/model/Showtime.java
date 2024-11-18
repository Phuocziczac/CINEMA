package com.poly.model;

import java.io.Serializable;
import java.time.LocalTime;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Showtime", uniqueConstraints = {
	    @UniqueConstraint(columnNames = {"StartTime", "EndTime", "Room_ID"})
	})
public class Showtime implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "StartTime", nullable = false)
    private LocalTime startTime;

    @Column(name = "EndTime", nullable = false)
    private LocalTime endTime;

    // Relationship with Room
    @ManyToOne
    @JoinColumn(name = "Room_ID", nullable = false)
    private Room room;

    // Getters and Setters
}
