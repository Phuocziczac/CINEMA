package com.poly.model;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Services")
public class Service implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "Name", nullable = false, unique = true)
    private String name;
    
    @Column(name = "Price", nullable = false)
    private double price;
    
    @Column(name = "Quantity", nullable = false)
    private int quantity;
    
    @Column(name = "Images", nullable = false)
    private String images;
    
    @Column(name = "Status", nullable = false)
    private boolean status;
    
    @Column(name = "CreatedAt", nullable = false)
    private java.util.Date createdAt;
    
    @Column(name = "UpdatedAt", nullable = false)
    private java.util.Date updatedAt;

}
