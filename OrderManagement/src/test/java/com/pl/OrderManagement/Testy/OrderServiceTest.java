package com.pl.OrderManagement.Testy;

import com.pl.OrderManagement.Objects.Customer;
import com.pl.OrderManagement.Objects.Order;
import com.pl.OrderManagement.Repositories.CustomerRepository;
import com.pl.OrderManagement.Repositories.OrderRepository;
import com.pl.OrderManagement.Service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private OrderService orderService;

    private Customer customer;
    private Order order;

    @BeforeEach
    void setUp() {
        customer = new Customer("Jan", "Kowalski");
        order = new Order(customer, "Wymiana oleju", "Wymiana oleju na syntetyczny", 200.00);
    }

    @Test
    void shouldReturnAllOrders() {
        when(orderRepository.findAll()).thenReturn(Arrays.asList(order));

        List<Order> orders = orderService.getAllOrders();

        assertEquals(1, orders.size());
        assertEquals("Wymiana oleju", orders.get(0).getOrderName());
        verify(orderRepository, times(1)).findAll();
    }

    @Test
    void shouldAddOrder() {
        when(orderRepository.save(any(Order.class))).thenReturn(order);

        Order savedOrder = orderService.addOrder(order);

        assertNotNull(savedOrder);
        assertEquals("Wymiana oleju", savedOrder.getOrderName());
        verify(orderRepository, times(1)).save(order);
    }

    @Test
    void shouldReturnOrdersByCustomerID() {
        when(customerRepository.findById(anyInt())).thenReturn(Optional.of(customer));
        when(orderRepository.findByOrderedBy(customer)).thenReturn(Arrays.asList(order));

        List<Order> orders = orderService.getOrdersByCustomerID(1);

        assertFalse(orders.isEmpty());
        assertEquals("Wymiana oleju", orders.get(0).getOrderName());
        verify(orderRepository, times(1)).findByOrderedBy(customer);
    }

    @Test
    void shouldThrowExceptionWhenCustomerNotFound() {
        when(customerRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () -> orderService.getOrdersByCustomerID(99));

        assertEquals("Customer not found", exception.getMessage());
    }
}
