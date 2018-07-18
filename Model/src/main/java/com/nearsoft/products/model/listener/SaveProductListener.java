package com.nearsoft.products.model.listener;

import com.nearsoft.products.libs.model.Product;
import com.nearsoft.products.model.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

@Component
public class SaveProductListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(SaveProductListener.class);

    @Autowired
    private ProductService productService;

    private CountDownLatch latch = new CountDownLatch(1);

    public CountDownLatch getLatch() {
        return latch;
    }

    @KafkaListener(topics = "${kafka.topic.save}")
    public void saveProduct(Product product){
        productService.save(product);
        LOGGER.info("persisted payload='{}'", product);
        latch.countDown();
    }
}
