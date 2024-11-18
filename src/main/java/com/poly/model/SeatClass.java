package com.poly.model;

import java.io.Serializable;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "SeatClass")

public class SeatClass implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Name", nullable = false, unique = true,columnDefinition = "NVARCHAR(50)")
    private String name;

    @Column(name = "PriceMultiplier", nullable = false)
    private double priceMultiplier;
}
