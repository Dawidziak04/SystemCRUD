package com.pl.OrderManagement.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "customers")
@Entity
@Getter
@Setter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerID;

    private String name;
    private String surname;

    public Customer() {}

    public Customer(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
    }