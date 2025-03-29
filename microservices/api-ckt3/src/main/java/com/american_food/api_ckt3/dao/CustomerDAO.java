package com.american_food.api_ckt3.dao;

import com.american_food.api_ckt3.entity.Customer;

import java.util.List;

public interface CustomerDAO {
    Customer getCustomerById(int id);
    List<Customer> getAllCustomers();
    Customer saveCustomer(Customer customer);
    void deleteCustomer(int id);
}
