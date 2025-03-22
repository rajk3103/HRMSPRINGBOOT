package com.fullstack.controller;

import com.fullstack.model.Customer;
import com.fullstack.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
@Slf4j
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping ("/signup")
    public ResponseEntity<Customer> signup(@RequestBody Customer customer) {

        log.info("####### Trying to save data for Customer: " + customer.getCustName());
        return ResponseEntity.of(customerService.SignUp(customer));

    }


}
