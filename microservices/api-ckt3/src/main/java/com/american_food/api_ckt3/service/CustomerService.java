package com.american_food.api_ckt3.service;

import com.american_food.api_ckt3.entity.Customer;

import java.util.List;

public interface CustomerService {
    Customer getCustomerById(int id);
    List<Customer> getAllCustomers();
    Customer saveCustomer(Customer customer);
    void deleteCustomer(int id);
}
