package com.blabla.spring.dao;

import com.blabla.spring.entity.Customer;
import java.util.List;

/**
 *
 * @author abdel
 */
public interface CustomerDAO {

    public List<Customer> getCustomers();

    public void saveCustomer(Customer theCustomer);

    public Customer getCustomer(int theId);

    public void deleteCustomer(int theId);

}
