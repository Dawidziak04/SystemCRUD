package com.pl.OrderManagement.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderID;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customerID", nullable = false)
    private Customer orderedBy;

    @Column(name = "orderName")
    private String orderName;

    @Column(name = "orderDescription")
    private String orderDescription;

    @Column(name = "orderValue")
    private double orderValue;

    public Order() {}

    public Order(Customer orderedBy, String orderName, String orderDescription, double orderValue) {
        this.orderedBy = orderedBy;
        this.orderName = orderName;
        this.orderDescription = orderDescription;
        this.orderValue = orderValue;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public Customer getOrderedBy() {
        return orderedBy;
    }

    public void setOrderedBy(Customer orderedBy) {
        this.orderedBy = orderedBy;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getOrderDescription() {
        return orderDescription;
    }

    public void setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
    }

    public double getOrderValue() {
        return orderValue;
    }

    public void setOrderValue(double orderValue) {
        this.orderValue = orderValue;
    }
}
