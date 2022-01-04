package com.blabla.spring.rest;

import com.blabla.spring.entity.Customer;
import com.blabla.spring.service.CustomerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author abdel
 */
@RestController
@RequestMapping("/api")
public class CustomerRestController {
    
    @Autowired
    private CustomerService customerService;
    
    @GetMapping("/customers")
    public List<Customer> getCustomers(){
        
        return customerService.getCustomers();
    }
    
    @GetMapping("/customers/{customerId}")
    public Customer geCustomer(@PathVariable int customerId){
        
        Customer theCustomer = customerService.getCustomer(customerId);
        
        if (theCustomer == null){
            throw new CustomerNotFoundException();
        }
        return theCustomer;
    }
    
    // add mapping for POST/customers - to add new customer
    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer theCustomer){
            
        // setting the id = 0 because of using saveorupdate in hibernate
        // the new customer will be created if only the id is null or =0
        theCustomer.setId(0);
        
        customerService.saveCustomer(theCustomer);
        
        return theCustomer;
    }
    
    // add mapping for put / customers - to update an existing customer
    @PutMapping("/customers")
    public Customer updateCustomer(@RequestBody Customer theCustomer){
        
        customerService.saveCustomer(theCustomer);
        
        return theCustomer;
    }
    
    // add mapping for delete/customers/{customerId} - to delete a customer
    @DeleteMapping("/customers/{customerId}")
    public String deleteCustomer(@PathVariable int customerId){
        
        Customer tempCustomer = customerService.getCustomer(customerId);
        
        if (tempCustomer == null){
            throw new CustomerNotFoundException("customer id not found - " + customerId);
        }
        
        customerService.deleteCustomer(customerId);
        
        return "Deleted customer id - " + customerId;
    }
}
