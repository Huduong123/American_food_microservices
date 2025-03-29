package com.american_food.api_ckt3.dao;

import com.american_food.api_ckt3.entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDAOImp implements  ProductDAO{
    private EntityManager em;

    public ProductDAOImp(EntityManager em) {
        this.em = em;
    }

    @Override
    public Product getProductById(int id) {
        return em.find(Product.class, id);
    }

    @Override
    public List<Product> getAllProducts() {
        TypedQuery<Product> query = em.createQuery("select p from Product p", Product.class);
        return query.getResultList();
    }

    @Override
    public Product saveProduct(Product product) {
        return em.merge(product);
    }

    @Override
    public void deleteProduct(int id) {
        em.remove(em.find(Product.class, id));
    }
}
