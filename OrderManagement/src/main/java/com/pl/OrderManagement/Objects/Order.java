package com.pl.OrderManagement.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "orders")
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderID;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customerID", nullable = false)
    private Customer orderedBy;

    private String orderName;

    private String orderDescription;

    private double orderValue;

    public Order() {}

    public Order(Customer orderedBy, String orderName, String orderDescription, double orderValue) {
        this.orderedBy = orderedBy;
        this.orderName = orderName;
        this.orderDescription = orderDescription;
        this.orderValue = orderValue;
    }

}
