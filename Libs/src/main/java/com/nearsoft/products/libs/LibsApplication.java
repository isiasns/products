package com.nearsoft.products.libs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan("com.nearsoft.products.libs")
@SpringBootApplication
public class LibsApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibsApplication.class, args);
    }
}
