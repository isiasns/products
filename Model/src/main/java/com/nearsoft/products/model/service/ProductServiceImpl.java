package com.nearsoft.products.model.service;

import com.nearsoft.products.libs.model.Product;
import com.nearsoft.products.model.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }
}
