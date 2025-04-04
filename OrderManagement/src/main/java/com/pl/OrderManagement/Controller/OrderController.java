package com.pl.OrderManagement.Controller;


import com.pl.OrderManagement.Objects.Order;
import com.pl.OrderManagement.Repositories.OrderRepository;
import com.pl.OrderManagement.Service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class OrderController {

    private final OrderService orderService;
    private final OrderRepository orderRepository;

    public OrderController(OrderService orderService, OrderRepository orderRepository) {
        this.orderService = orderService;
        this.orderRepository = orderRepository;
    }

    @GetMapping("/orders")
    public List<Order> getOrders(){
        return orderService.getAllOrders();
    }

    @GetMapping("/orders/{orderID}")
    public ResponseEntity<Order> getOrder(@PathVariable int orderID) {
        Optional<Order> choosenOrder = orderRepository.findById(orderID);
        return choosenOrder.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }
    @GetMapping("customerOrders/{customerID}")
    public List<Order> getOrdersByCustomerID(@PathVariable int customerID) {
        return orderService.getOrdersByCustomerID(customerID);
    }

   @PutMapping("/editOrder")
    public ResponseEntity<Order> updateOrder(@RequestBody Order order){
    Order updatedOrder = orderService.updateOrder(order);
       if (updatedOrder != null) {
           return new ResponseEntity<>(updatedOrder, HttpStatus.OK);
       }
       else {
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }

   }

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

