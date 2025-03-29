package com.fullstack.controller;

import com.fullstack.exception.RecordAlreadyExistException;
import com.fullstack.exception.RecordNotFoundException;
import com.fullstack.model.Customer;
import com.fullstack.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
@Slf4j
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping ("/signup")
    public ResponseEntity<Customer> signup(@RequestBody Customer customer) {

        log.info("####### Trying to save data for Customer: " + customer.getCustName());

        Customer customer1= customerService.findByEmailId(customer.getCustEmailId());

        if(customer1 != null) {

            throw new RecordAlreadyExistException("Customer with email id " + customer.getCustEmailId() + " is already exist");
        }

        return ResponseEntity.ok(customerService.SignUp(customer));

    }
@GetMapping("/signin/{custEmailId}/{custPassword}")
    public ResponseEntity<Boolean> signin(@PathVariable String custEmailId, @PathVariable String custPassword) {
        return ResponseEntity.ok(customerService.SignIn(custEmailId, custPassword));
    }
@GetMapping("/findbyid/{custId}")
    public ResponseEntity<Optional<Customer>> findById(@PathVariable int custId) {
        return ResponseEntity.ok(customerService.findById(custId));
}
@GetMapping("/findall")
    public ResponseEntity<List<Customer>> findAll() {
        return ResponseEntity.ok(customerService.findAll());
}
@GetMapping("/findbyname/{custName}")
    public ResponseEntity<Optional<Customer>> findByName(@PathVariable String custName) {
            return ResponseEntity.ok(customerService.findByName(custName));
}
@GetMapping("/sortbyname")
    public ResponseEntity<List<Customer>> sortByName() {
        return ResponseEntity.ok(customerService.findAll().stream().sorted(Comparator.comparing(Customer::getCustName)).toList());

}
    @GetMapping("/sortbydob")
    public ResponseEntity<List<Customer>> sortByName() {
        return ResponseEntity.ok(customerService.findAll().stream().sorted(Comparator.comparing(Customer::getCustDOB)).toList());

    }
    @GetMapping("/sortbyaccbalance")
    public ResponseEntity<List<Customer>> sortByName() {
        return ResponseEntity.ok(customerService.findAll().stream().sorted(Comparator.comparing(Customer::getCustAccountBalance)).toList());

    }
    @GetMapping("/findbydob/{custDOB}")
    public ResponseEntity<List<Customer>> findByDOB(@PathVariable String custDOB) {
        SimpleDateFormat simpleDateFormat= new SimpleDateFormat("dd/MM/yyyy");

        return ResponseEntity.ok(customerService.findAll().stream().filter(cust ->simpleDateFormat.format(cust.getCustDOB()).equals(custDOB)).toList());

    }
    @GetMapping("/findbyanyinput/{input}")
    public ResponseEntity<List<Customer>> findByAnyInput(@PathVariable String input) {

        SimpleDateFormat simpleDateFormat= new SimpleDateFormat("dd/MM/yyyy");

        return ResponseEntity.ok(customerService.findAll().stream().filter(cust->simpleDateFormat.format(cust.getCustDOB()).equals(input)
                || cust.getCustName().equals(input)
                || String.valueOf(cust.getCustId()).equals(input)
                || String.valueOf(cust.getCustomerName()).equals(input)
                || cust.getCustEmailId().equals(input)) .toList());
    }

    @PutMapping("/update/{custId}")
    public ResponseEntity<Customer> update(@PathVariable int custId, @RequestBody Customer customer) {
        Customer customer1=customerService.findById(custId).orElseThrow(()->new RecordNotFoundException("Customer #ID  Does not Exist"));

        customer1.setCustName(customer.getCustName());
        customer1.setCustAddress(customer.getCustAddress());
        customer1.setCustContactNumber(customer.getCustContactNumber());

        customer1.setCustAccountBalance(customer.getCustAccountBalance());
        customer1.setCustEmailId(customer.getCustEmailId());
        customer1.setCustPassword(customer.getCustPassword());

        return ResponseEntity.ok(customerService.update(customer1));

    }

    @DeleteMapping("/deletebyid/{custId}")
    public ResponseEntity<String> deleteById(@PathVariable int custId) {
        customerService.deleteById(custId);
        return ResponseEntity.ok("Successfully Deleted Customer id #" + custId);
    }

    @DeleteMapping("/deleteall/{custid}")
    public ResponseEntity<String> deleteAll() {
        customerService.deleteAll();
        return ResponseEntity.ok("Successfully Deleted All Customers");

    }



}
