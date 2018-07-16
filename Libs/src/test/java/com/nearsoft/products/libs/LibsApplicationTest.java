package com.nearsoft.products.libs;

import com.nearsoft.products.libs.kafka.consumer.Consumer;
import com.nearsoft.products.libs.kafka.producer.Producer;
import com.nearsoft.products.libs.model.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ComponentScan("com.nearsoft.products.libs")
@SpringBootTest
public class LibsApplicationTest {

    @Autowired
    private Producer producer;

    @Test
    public void testReceive() throws Exception {
        Product product = Product.builder().id(1).name("Name").description("Description").sku("SKU")
                .manufacturer("Manufacturer").price(0.0).build();
        producer.send(product);
    }
}
