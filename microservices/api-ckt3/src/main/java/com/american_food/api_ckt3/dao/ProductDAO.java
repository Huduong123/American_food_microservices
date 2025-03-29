package com.american_food.api_ckt3.dao;

import com.american_food.api_ckt3.entity.Product;

import java.util.List;

public interface ProductDAO {
    Product getProductById(int id);
    List<Product> getAllProducts();
    Product saveProduct(Product product);
    void deleteProduct(int id);
}
