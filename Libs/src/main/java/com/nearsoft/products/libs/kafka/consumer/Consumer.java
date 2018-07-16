package com.nearsoft.products.libs.kafka.consumer;

import com.nearsoft.products.libs.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);

    @KafkaListener(topics = "${kafka.topic}")
    public void receive(@Payload Product product, @Headers MessageHeaders messageHeaders) {
        LOGGER.info("received payload='{}'", product);
        messageHeaders.keySet().forEach(key -> {
            LOGGER.info("{}: {}", key, messageHeaders.get(key));
        });
    }
}
