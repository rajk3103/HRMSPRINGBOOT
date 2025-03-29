package com.fullstack.service;

import com.fullstack.model.Customer;
import org.hibernate.mapping.List;
//import java.util.List;
import java.util.Optional;

public interface CustomerService {

    Customer findByEmailId(String custEmailId);

    Customer SignUp(Customer customer);

    boolean SignIn(String custEmailId, String custPassword);

    Optional<Customer> findById(int custId);

    List<Customer> findAll();

    List<Customer> findByName (String custName);

    Customer update(Customer customer);

    void deleteById(int custId);

    void deleteAll();
