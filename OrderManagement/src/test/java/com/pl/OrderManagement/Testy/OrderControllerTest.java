package com.pl.OrderManagement.Controller;

import com.pl.OrderManagement.Objects.Customer;
import com.pl.OrderManagement.Objects.Order;
import com.pl.OrderManagement.Service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class OrderControllerTest {

    @Mock
    private OrderService orderService;

    @InjectMocks
    private OrderController orderController;

    private MockMvc mockMvc;

    private Order order;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(orderController).build();
        order = new Order(new Customer("Jan", "Kowalski"), "Diagnostyka", "Diagnostyka silnika", 150.00);
    }

    @Test
    void shouldReturnAllOrders() throws Exception {
        List<Order> orders = Arrays.asList(order);
        when(orderService.getAllOrders()).thenReturn(orders);

        mockMvc.perform(get("/orders")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(1))
                .andExpect(jsonPath("$[0].orderName").value("Diagnostyka"));

        verify(orderService, times(1)).getAllOrders();
    }
}
