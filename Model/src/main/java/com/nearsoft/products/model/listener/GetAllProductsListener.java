package com.nearsoft.products.model.listener;

import com.nearsoft.products.libs.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

@Component
public class GetAllProductsListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(GetAllProductsListener.class);

    private CountDownLatch latch = new CountDownLatch(1);

    public CountDownLatch getLatch() {
        return latch;
    }

    @KafkaListener(topics = "${kafka.topic.list}")
    public void getAllProducts(Product product) {
        LOGGER.info("receiving payload='{}'", product);
        latch.countDown();
    }
}
