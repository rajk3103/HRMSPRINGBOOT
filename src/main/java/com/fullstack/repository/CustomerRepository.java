package com.fullstack.repository;

import com.fullstack.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    //Custom Methods

    List<Customer> findByCustName(String custName);

    Customer findByCustEmailIdAndCustPassword(String custEmailId, String custPassword);


}
