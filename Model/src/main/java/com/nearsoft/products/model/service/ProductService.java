package com.nearsoft.products.model.service;

import com.nearsoft.products.libs.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    void save(Product product);
}
