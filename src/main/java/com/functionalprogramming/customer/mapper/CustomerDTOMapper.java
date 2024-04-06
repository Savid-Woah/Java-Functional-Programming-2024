package com.functionalprogramming.customer.mapper;

import com.functionalprogramming.customer.dto.CustomerDTO;
import com.functionalprogramming.customer.model.Customer;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class CustomerDTOMapper implements Function<Customer, CustomerDTO> {
    @Override
    public CustomerDTO apply(Customer customer) {
        return new CustomerDTO(
                customer.getCustomerId(),
                customer.getName(),
                customer.getLastName(),
                customer.getEmail()
        );
    }
}