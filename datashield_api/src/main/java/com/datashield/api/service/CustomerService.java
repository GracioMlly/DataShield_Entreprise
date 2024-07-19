package com.datashield.api.service;

import com.datashield.api.entities.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getCustomers();

    Customer createCustomer(Customer customer);

    public void init();
}
