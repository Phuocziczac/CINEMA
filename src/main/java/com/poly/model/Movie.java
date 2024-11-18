package com.poly.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Movie")
public class Movie implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "Name", nullable = false, unique = true)
    private String name;
    
    @Column(name = "Movie_duration", nullable = false)
    private int movieDuration;
    
    @Column(name = "Content", nullable = false)
    private String content;
    
    @Column(name = "ReleaseDate", nullable = false)
    private java.sql.Date releaseDate;
    
    @Column(name = "Director", nullable = false)
    private String director;
    
    @Column(name = "Performer", nullable = false)
    private String performer;
    
    @Column(name = "LinkTrailer", nullable = false, unique = true)
    private String linkTrailer;
    
    @Column(name = "Status", nullable = false)
    private boolean status;
    
    @Column(name = "Created_at", nullable = false)
    private java.sql.Timestamp createdAt;
    
    @Column(name = "Updated_at", nullable = false)
    private java.sql.Timestamp updatedAt;
    
  
    
    @Column(name = "Images", nullable = false)
    private String images;
    // Quan hệ nhiều-nhiều với Category thông qua MovieCategory
    @OneToMany(mappedBy = "movie")
    private Set<MovieCategory> movieCategories;
    // Getters and Setters
}
