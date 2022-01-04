package com.blabla.spring.service;

import com.blabla.spring.entity.Customer;
import java.util.List;

/**
 *
 * @author abdel
 */
public interface CustomerService {

    public List<Customer> getCustomers();

    public void saveCustomer(Customer theCustomer);

    public Customer getCustomer(int theId);

    public void deleteCustomer(int theId);

}