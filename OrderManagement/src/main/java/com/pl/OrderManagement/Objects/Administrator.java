package com.pl.OrderManagement.Objects;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "administrator")
public class Administrator {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int AdministratorID;

    private String username;
    private String password;

    public Administrator() {}

    public Administrator(int administratorID, String username, String password) {
        AdministratorID = administratorID;
        this.username = username;
        this.password = password;
    }

}
