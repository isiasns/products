package com.nearsoft.products.model.service;

import com.nearsoft.products.libs.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    List<Product> findAll();

    void save(Product product);
}
