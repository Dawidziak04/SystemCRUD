package com.pl.SystemCRUD.Repositories;

import com.pl.SystemCRUD.Objects.Customer;
import com.pl.SystemCRUD.Objects.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    void deleteById(Integer customerID);

    Optional<Customer> findByCustomerID(int customerID);

}
