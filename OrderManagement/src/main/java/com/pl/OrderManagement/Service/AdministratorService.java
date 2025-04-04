package com.pl.OrderManagement.Service;

import com.pl.OrderManagement.Objects.Administrator;
import com.pl.OrderManagement.Repositories.AdministratorRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdministratorService {

    private final AdministratorRepository administratorRepository;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public AdministratorService(AdministratorRepository administratorRepository) {
        this.administratorRepository = administratorRepository;
    }

    public Administrator register(Administrator administrator) {
        administrator.setPassword(encoder.encode(administrator.getPassword()));
        return administratorRepository.save(administrator);
    }
}