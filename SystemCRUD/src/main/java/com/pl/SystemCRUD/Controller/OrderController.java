package com.pl.SystemCRUD.Controller;


import com.pl.SystemCRUD.Objects.Customer;
import com.pl.SystemCRUD.Objects.Order;
import com.pl.SystemCRUD.Repositories.OrderRepository;
import com.pl.SystemCRUD.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

   // @GetMapping("/editOrder")
   // public

   @PostMapping("/postOrder")
    public Order postOrder(@RequestBody Order order) {
    return orderService.addOrder(order);
   }

   @DeleteMapping ("/deleteOrder/{orderID}")
    public ResponseEntity<String> deleteOrder(@PathVariable int orderID) {
       boolean deleted = orderService.deleteOrder(orderID);

       if (deleted) {
           return ResponseEntity.ok("Order: " + orderID + " deleted successfully.");
       } else {
           return ResponseEntity.status(HttpStatus.NOT_FOUND)
                   .body("Order: " + orderID + " not found.");
       }
   }

}

