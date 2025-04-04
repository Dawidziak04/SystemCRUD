package com.pl.OrderManagement.Repositories;

import com.pl.OrderManagement.Objects.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministratorRepository extends JpaRepository<Administrator, Integer> {

    Administrator findByUsername(String username);

}
