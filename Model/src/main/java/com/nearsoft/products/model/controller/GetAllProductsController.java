package com.nearsoft.products.model.controller;

import com.nearsoft.products.libs.kafka.producer.KafkaProductProducer;
import com.nearsoft.products.libs.model.Product;
import com.nearsoft.products.model.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/productsList")
public class GetAllProductsController {

    @Value("${kafka.topic.list}")
    private String listTopic;

    @Autowired
    private ProductService productService;

    @Autowired
    private KafkaProductProducer kafkaProductProducer;

    @RequestMapping()
    public void getAllProducts() {
        for (Product product : productService.findAll()) {
            kafkaProductProducer.send(product, listTopic);
        }
    }
}
