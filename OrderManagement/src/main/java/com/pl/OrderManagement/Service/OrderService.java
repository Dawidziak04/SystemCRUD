package com.pl.OrderManagement.Service;


import com.pl.OrderManagement.Objects.Customer;
import com.pl.OrderManagement.Objects.Order;
import com.pl.OrderManagement.Repositories.CustomerRepository;
import com.pl.OrderManagement.Repositories.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    private final CustomerRepository customerRepository;

    public OrderService(OrderRepository orderRepository, CustomerRepository customerRepository) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
    }

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

    public Order updateOrder(Order updatedOrder) {
        Optional<Order> existingOrder = orderRepository.findByOrderID(updatedOrder.getOrderID());
        if (existingOrder.isPresent()) {
            Order orderToUpdate = existingOrder.get();
            orderToUpdate.setOrderID(updatedOrder.getOrderID());
            orderToUpdate.setOrderedBy(updatedOrder.getOrderedBy());
            orderToUpdate.setOrderName(updatedOrder.getOrderName());
            orderToUpdate.setOrderDescription(updatedOrder.getOrderDescription());
            orderToUpdate.setOrderValue(updatedOrder.getOrderValue());
            orderRepository.save(orderToUpdate);
            return orderToUpdate;
        }
        return null;
    }
}
