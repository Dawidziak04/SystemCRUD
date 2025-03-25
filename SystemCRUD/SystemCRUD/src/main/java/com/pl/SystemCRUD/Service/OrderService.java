package com.pl.SystemCRUD.Service;


import com.pl.SystemCRUD.Objects.Customer;
import com.pl.SystemCRUD.Objects.Order;
import com.pl.SystemCRUD.Repositories.CustomerRepository;
import com.pl.SystemCRUD.Repositories.OrderRepository;
import jakarta.transaction.Transactional;
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

    @Transactional
    public Order addOrder(Order order){
        return orderRepository.save(order);
    }

    public List<Order> getOrdersByCustomerID(int customerID) {
        Customer customer = customerRepository.findById(customerID)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        return orderRepository.findByOrderedBy(customer);
    }

    @Transactional
    public boolean deleteOrder(int orderID) {
        if (orderRepository.existsById(orderID)) {
            orderRepository.deleteById(orderID);
            return true;
        }
        return false;
    }

}
