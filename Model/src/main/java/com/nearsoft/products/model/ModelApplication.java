package com.nearsoft.products.model;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan("com.nearsoft.products.libs")
@SpringBootApplication
public class ModelApplication {

    public static void main(String[] args) {
        SpringApplication.run(ModelApplication.class, args);
    }
}
