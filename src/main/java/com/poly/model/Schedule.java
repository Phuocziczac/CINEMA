package com.poly.model;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Schedule", uniqueConstraints = {
	    @UniqueConstraint(columnNames = {"ScreeningDate", "Movie_ID", "Showtime_ID"})
	})
public class Schedule implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
   
    @Column(name = "ScreeningDate", nullable = false)
  // Chỉ lấy phần ngày
    private LocalDate screeningDate;


    // Relationship with Movie
    @ManyToOne
    @JoinColumn(name = "Movie_ID", nullable = false)
    private Movie movie;

    // Relationship with Showtime
    @ManyToOne
    @JoinColumn(name = "Showtime_ID", nullable = false)
    private Showtime showtime;

    
}
