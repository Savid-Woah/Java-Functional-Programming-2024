package com.functionalprogramming.customer.service;

import com.functionalprogramming.customer.dto.CustomerDTO;
import com.functionalprogramming.customer.mapper.CustomerDTOMapper;
import com.functionalprogramming.customer.model.Customer;
import com.functionalprogramming.customer.repository.CustomerRepository;
import com.functionalprogramming.customer.request.CustomerRequest;
import com.functionalprogramming.exception.BackendException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.functionalprogramming.exception.MsgCode.OOPS_ERROR;

@Service
@Transactional
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerDTOMapper customerDTOMapper;
    private final CustomerRepository customerRepository;

    public List<CustomerDTO> getAllCustomers() {

        return customerRepository.findAll()
                .stream()
                .map(customerDTOMapper)
                .collect(Collectors.toList());
    }

    public String addCustomer(CustomerRequest customerRequest){

        String email = customerRequest.getEmail();
        Optional<Customer> customerOptional = customerRepository
                .findByEmailIgnoreCase(email);

        if(customerOptional.isEmpty()) {

            Customer customer = new Customer(customerRequest);
            customerRepository.save(customer);
            return "Customer saved successfully!";
        }
        else{
            throw new BackendException(OOPS_ERROR);
        }
    }
}