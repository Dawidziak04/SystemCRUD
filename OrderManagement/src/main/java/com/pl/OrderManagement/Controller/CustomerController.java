package com.pl.OrderManagement.Controller;


import com.pl.OrderManagement.Objects.Customer;
import com.pl.OrderManagement.Repositories.CustomerRepository;
import com.pl.OrderManagement.Service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {


    private final CustomerService customerService;
    private final CustomerRepository customerRepository;

    public CustomerController(CustomerService customerService, CustomerRepository customerRepository) {
        this.customerService = customerService;
        this.customerRepository = customerRepository;
    }

    @GetMapping("/customers")
    public List<Customer> getCustomers() {
       return customerService.getAllCustomers();
    }

    @GetMapping("/customers/{customerID}")
    public ResponseEntity<Customer> getCustomer(@PathVariable int customerID) {
        Optional<Customer> choosenCustomer = customerRepository.findById(customerID);
        return choosenCustomer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    @PostMapping("/postCustomer")
    public ResponseEntity<Customer> postCustomer(@RequestBody Customer customer) {
        Customer createdCustomer = customerService.addCustomer(customer);
        return new ResponseEntity<>(createdCustomer, HttpStatus.CREATED);
    }


    @DeleteMapping ("/deleteCustomer/{customerID}")
    public ResponseEntity<String> deleteCustomer(@PathVariable int customerID) {
        boolean deleted = customerService.deleteCustomer(customerID);

        if (deleted) {
            return ResponseEntity.ok("Customer: " + customerID + " deleted successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Customer: " + customerID + " not found.");
        }
    }

    @PutMapping("/editCustomer")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer){
        Customer updatedCustomer = customerService.updateCustomer(customer);
        if (updatedCustomer != null) {
            return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

}
