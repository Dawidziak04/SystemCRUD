package com.pl.SystemCRUD.Service;

import com.pl.SystemCRUD.Objects.Customer;
import com.pl.SystemCRUD.Repositories.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService;

    private Customer customer;

    @BeforeEach
    void setUp() {
        customer = new Customer("Anna", "Nowak");
    }

    @Test
    void shouldReturnAllCustomers() {
        when(customerRepository.findAll()).thenReturn(Arrays.asList(customer));

        List<Customer> customers = customerService.getAllCustomers();

        assertEquals(1, customers.size());
        assertEquals("Anna", customers.get(0).getName());
        verify(customerRepository, times(1)).findAll();
    }

    @Test
    void shouldAddCustomer() {
        when(customerRepository.save(any(Customer.class))).thenReturn(customer);

        Customer savedCustomer = customerService.addCustomer(customer);

        assertNotNull(savedCustomer);
        assertEquals("Anna", savedCustomer.getName());
        verify(customerRepository, times(1)).save(customer);
    }
}
