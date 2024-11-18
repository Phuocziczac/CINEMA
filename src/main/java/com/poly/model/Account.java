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
@Table(name = "Account")
public class Account implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Username", nullable = false, unique = true, columnDefinition = "NVARCHAR(255)")
    private String username;

    @Column(name = "Password", nullable = false, columnDefinition = "NVARCHAR(255)")
    private String password;

    @Column(name = "Email", nullable = false, unique = true, columnDefinition = "NVARCHAR(255)")
    private String email;

    @Column(name = "Fullname", nullable = false, columnDefinition = "NVARCHAR(255)")
    private String fullname;

    @Column(name = "Birth_day", nullable = false)
    private java.util.Date birthDay;

    @Column(name = "Gender", nullable = false)
    private boolean gender;

    @Column(name = "Phone", nullable = false, unique = true, columnDefinition = "NVARCHAR(255)")
    private String phone;

    @Column(name = "Images", nullable = false, columnDefinition = "NVARCHAR(255)")
    private String images;

    // Relationship with Role
    @ManyToOne
    @JoinColumn(name = "Role_ID", nullable = false)
    private Role role;

    // Getters and Setters
}
