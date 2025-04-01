package com.pl.OrderManagement.Repositories;

import com.pl.OrderManagement.Objects.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    void deleteById(Integer customerID);

    Optional<Customer> findByCustomerID(int customerID);

}
