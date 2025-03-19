package com.pl.SystemCRUD.Repositories;

import com.pl.SystemCRUD.Objects.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
