package com.pl.OrderManagement.Service;

import com.pl.OrderManagement.Objects.Administrator;
import com.pl.OrderManagement.Objects.AdministratorPrincipal;
import com.pl.OrderManagement.Repositories.AdministratorRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final AdministratorRepository administratorRepository;

    public CustomUserDetailsService(AdministratorRepository administratorRepository) {
        this.administratorRepository = administratorRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Administrator administrator = administratorRepository.findByUsername(username);

        if (administrator == null) {
            System.out.printf("Username %s not found: ", username);
            throw new UsernameNotFoundException("Username: " + username + " not found");
        }

        return new AdministratorPrincipal(administrator);
    }
}
