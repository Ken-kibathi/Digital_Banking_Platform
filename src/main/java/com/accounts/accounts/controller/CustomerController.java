package com.accounts.accounts.controller;

import com.accounts.accounts.model.Customer;
import com.accounts.accounts.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/create")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customerRequest) {
        Customer customer = customerService.createCustomer(
                customerRequest.getFullName(),
                customerRequest.getEmail(),
                customerRequest.getPhoneNumber(),
                customerRequest.getAddress()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(customer);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable Long id) {
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }
}

