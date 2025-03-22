package com.fullstack.service;

import com.fullstack.model.Customer;
import com.fullstack.repository.CustomerRepository;
import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer SignUp(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public boolean SignIn(String custEmailId, String custPassword) {
        boolean flag = false;

        Customer customer= customerRepository.findByCustEmailIdAndCustPassword(custEmailId, custPassword);
        if(customer != null && customer.getCustEmail().equals(custEmailId) && customer.getCustPassword().equals(custPassword)){
            flag = true;
        }
        return flag;
    }

    @Override
    public Optional<Customer> findById(int custId) {
        return Optional.empty();
    }

    @Override
    public List<Customer> findAll() {
        return null;
    }

    @Override
    public List<Customer> findByName(String custName) {
        return null;
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return null;
    }

    @Override
    public void deleteById(int custId) {

    }

    @Override
    public void deleteAll() {

    }
}
