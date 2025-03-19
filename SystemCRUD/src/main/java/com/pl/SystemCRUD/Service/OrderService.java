package com.pl.SystemCRUD.Service;


import com.pl.SystemCRUD.Objects.Customer;
import com.pl.SystemCRUD.Objects.Order;
import com.pl.SystemCRUD.Repositories.CustomerRepository;
import com.pl.SystemCRUD.Repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    CustomerRepository customerRepository;

    public List<Order> getAllOrders(){
       return orderRepository.findAll();
    }

    public Order addOrder(Order order){
        orderRepository.save(order);
        return order;
    }

    public List<Order> getOrdersByCustomerID(int customerID) {
        Customer customer = customerRepository.findById(customerID)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        return orderRepository.findByOrderedBy(customer);
    }

}
