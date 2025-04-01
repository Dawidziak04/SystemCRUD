package com.pl.OrderManagement.Repositories;


import com.pl.OrderManagement.Objects.Customer;
import com.pl.OrderManagement.Objects.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findByOrderedBy(Customer customer);


    void deleteById(Integer orderID);

    Optional<Order> findByOrderID(int orderID);
}
