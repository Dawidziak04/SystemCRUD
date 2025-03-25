package com.pl.SystemCRUD.Controller;


import com.pl.SystemCRUD.Objects.Customer;
import com.pl.SystemCRUD.Objects.Order;
import com.pl.SystemCRUD.Repositories.CustomerRepository;
import com.pl.SystemCRUD.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {


    @Autowired
    CustomerService customerService;
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/customers")
    public List<Customer> getCustomers() {
       return customerService.getAllCustomers();
    }

    @GetMapping("/customers/{customerID}")
    public ResponseEntity<Customer> getCustomer(@PathVariable int customerID) {
        Optional<Customer> choosenCustomer = customerRepository.findById(customerID);
        if (choosenCustomer.isPresent()) {
            return ResponseEntity.ok(choosenCustomer.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
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

}
