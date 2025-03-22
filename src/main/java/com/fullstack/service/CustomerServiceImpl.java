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
        return customerRepository.findById(custId);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public List<Customer> findByName(String custName) {
        return customerRepository.findByCustName(String custName);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void deleteById(int custId) {

        customerRepository.deleteById(custId);
    }

    @Override
    public void deleteAll() {

        customerRepository.deleteAll();
        }
}
