package com.nearsoft.products.model;

import com.nearsoft.products.model.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan("com.nearsoft.products.libs")
@SpringBootApplication
public class ModelApplication {
    @Autowired
    private ProductService productService;

    public static void main(String[] args) {
        SpringApplication.run(ModelApplication.class, args);
    }
}
