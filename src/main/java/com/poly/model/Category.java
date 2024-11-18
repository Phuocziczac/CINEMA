package com.poly.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Category")
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Name", nullable = true, length = 255)
    private String name;

    @Column(name = "Decription", nullable = true, length = 255)
    private String decription;

    // Quan hệ nhiều-nhiều với Movie thông qua MovieCategory
    @OneToMany(mappedBy = "category")
    private Set<MovieCategory> movieCategories;
}
