package com.pl.OrderManagement.Service;


import com.pl.OrderManagement.Objects.Customer;
import com.pl.OrderManagement.Repositories.CustomerRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

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

    public Customer updateCustomer(Customer updatedCustomer) {
        Optional<Customer> existingCustomer = customerRepository.findByCustomerID(updatedCustomer.getCustomerID());
        if (existingCustomer.isPresent()) {
            Customer customerToUpdate = existingCustomer.get();
            customerToUpdate.setCustomerID(updatedCustomer.getCustomerID());
            customerToUpdate.setName(updatedCustomer.getName());
            customerToUpdate.setSurname(updatedCustomer.getSurname());
            customerRepository.save(customerToUpdate);
            return customerToUpdate;
        }
        return null;
    }

}



