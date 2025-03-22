package com.fullstack.service;

import com.fullstack.model.Customer;
import org.hibernate.mapping.List;

import java.util.Optional;

public interface CustomerService {

    Customer SignUp(Customer customer);

    boolean SignIn(String custEmailId, String custPassword);

    Optional<Customer> findById(int custId);

    List<Customer> findAll();

    List<Customer> findByName (String custName);

    Customer updateCustomer(Customer customer);

    void deleteById(int custId);

    void deleteAll();

}
