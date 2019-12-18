package com.revature.bankingapp.dao;

import java.util.Set;

import com.revature.bankingapp.model.Customer;

public interface CustomerDao 
{
    Customer getCustomerById(Long idCustomer);
    Customer getCustomerBySsn(String ssn);
    //Customer getCustCustomerName(String CustomerName);
    //Set<Customer> getAllCustomers();
    boolean insert(Customer Customer);
    boolean update(Customer Customer);
    boolean delete(Long idCustomer);
}
