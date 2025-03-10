package com.accounts.accounts.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String fullName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String phoneNumber;

    @Column(nullable = false)
    private String address;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt = new Date();

    // Constructors, Getters, Setters
}
