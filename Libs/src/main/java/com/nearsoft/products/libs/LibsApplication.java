package com.nearsoft.products.libs;

import com.nearsoft.products.libs.kafka.producer.Producer;
import com.nearsoft.products.libs.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
public class LibsApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(LibsApplication.class, args);
    }

    @Autowired
    private Producer producer;

    @Override
    public void run(String... strings) throws Exception {
        Product product = Product.builder().id(1).name("Name").description("Description").sku("SKU")
                .manufacturer("Manufacturer").price(0.0).build();
        producer.send(product);
    }
}
