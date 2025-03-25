package com.pl.SystemCRUD.Service;


import com.pl.SystemCRUD.Objects.Customer;
import com.pl.SystemCRUD.Objects.Order;
import com.pl.SystemCRUD.Repositories.CustomerRepository;
import jakarta.persistence.EntityNotFoundException;
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



