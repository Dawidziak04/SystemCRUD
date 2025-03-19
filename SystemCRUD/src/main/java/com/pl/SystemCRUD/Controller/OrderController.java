package com.pl.SystemCRUD.Controller;


import com.pl.SystemCRUD.Objects.Customer;
import com.pl.SystemCRUD.Objects.Order;
import com.pl.SystemCRUD.Repositories.OrderRepository;
import com.pl.SystemCRUD.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;
    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/orders")
    public List<Order> getOrders(){
        return orderService.getAllOrders();
    }

    @GetMapping("/orders/{orderID}")
    public Order getOrder(@PathVariable int orderID) {
        return orderRepository.getById(orderID);
    }

    @GetMapping("customerOrders/{customerID}")
    public List<Order> getOrdersByCustomerID(@PathVariable int customerID) {
        return orderService.getOrdersByCustomerID(customerID);
    }

   @PostMapping("/postOrder")
    public Order postOrder(@RequestBody Order order) {
    return orderService.addOrder(order);
   }

}

