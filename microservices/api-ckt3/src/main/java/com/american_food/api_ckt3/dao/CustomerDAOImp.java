package com.american_food.api_ckt3.dao;

import com.american_food.api_ckt3.entity.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDAOImp implements CustomerDAO {
    private EntityManager em;

    public CustomerDAOImp(EntityManager em) {
        this.em = em;
    }

    @Override
    public Customer getCustomerById(int id) {
        return em.find(Customer.class, id);
    }

    @Override
    public List<Customer> getAllCustomers() {
        TypedQuery<Customer> query = em.createQuery("SELECT c FROM Customer c", Customer.class);
        return query.getResultList();
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return em.merge(customer);
    }

    @Override
    public void deleteCustomer(int id) {
em.remove(em.find(Customer.class, id));
    }
}
