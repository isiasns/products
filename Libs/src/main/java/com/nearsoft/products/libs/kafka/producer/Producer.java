package com.nearsoft.products.libs.kafka.producer;

import com.nearsoft.products.libs.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class Producer {
    private static final Logger LOGGER = LoggerFactory.getLogger(Producer.class);

    @Autowired
    private KafkaTemplate<String, Product> kafkaTemplate;

    @Value("${kafka.topic}")
    private String topic;

    public void send(Product product) {
        LOGGER.info("sending product='{}' to topic='{}'", product, topic);
        Message<Product> message = MessageBuilder
                .withPayload(product)
                .setHeader(KafkaHeaders.TOPIC, topic)
                .build();
        kafkaTemplate.send(message);
    }
}
