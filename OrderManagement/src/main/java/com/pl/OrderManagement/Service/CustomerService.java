package com.pl.OrderManagement.Service;


import com.pl.OrderManagement.Objects.Customer;
import com.pl.OrderManagement.Repositories.CustomerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
    return customerRepository.findAll();
    }


    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }



    @Transactional
    public boolean deleteCustomer(int customerID) {
        if (customerRepository.existsById(customerID)) {
            customerRepository.deleteById(customerID);
            return true;
        }
        return false;
    }

}



