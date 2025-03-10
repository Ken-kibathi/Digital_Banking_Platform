package com.accounts.accounts.services;

import com.accounts.accounts.model.Customer;
import com.accounts.accounts.repository.CustomerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer createCustomer(String fullName, String email, String phoneNumber, String address) {
        if (customerRepository.findByEmail(email).isPresent()) {
            throw new IllegalArgumentException("Email already exists");
        }
        if (customerRepository.findByPhoneNumber(phoneNumber).isPresent()) {
            throw new IllegalArgumentException("Phone number already exists");
        }

        Customer customer = new Customer();
        customer.setFullName(fullName);
        customer.setEmail(email);
        customer.setPhoneNumber(phoneNumber);
        customer.setAddress(address);
        return customerRepository.save(customer);
    }

    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Customer not found"));
    }
}