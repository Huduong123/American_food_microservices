package com.american_food.api_ckt3.service;

import com.american_food.api_ckt3.dao.CustomerDAO;
import com.american_food.api_ckt3.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImp implements CustomerService {
    private CustomerDAO customerDAO;

    public CustomerServiceImp(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @Override
    public Customer getCustomerById(int id) {
        return customerDAO.getCustomerById(id);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerDAO.getAllCustomers();
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerDAO.saveCustomer(customer);
    }

    @Override
    public void deleteCustomer(int id) {
    customerDAO.deleteCustomer(id);
    }
}
