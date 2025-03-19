package com.pl.SystemCRUD.Controller;


import com.pl.SystemCRUD.Objects.Customer;
import com.pl.SystemCRUD.Objects.Order;
import com.pl.SystemCRUD.Repositories.CustomerRepository;
import com.pl.SystemCRUD.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Customer getCustomer(@PathVariable int customerID) {
        return customerRepository.getById(customerID);
    }

    @PostMapping("/postCustomer")
    public Customer postCustomer(@RequestBody Customer customer) {
        return customerService.addCustomer(customer);
    }

}
