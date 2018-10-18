package com.nearsoft.products.view.controller;

import com.nearsoft.products.libs.kafka.producer.KafkaProductProducer;
import com.nearsoft.products.libs.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.naming.Binding;
import javax.validation.Valid;

@Controller
public class ProductController {

    @Autowired
    private KafkaProductProducer kafkaProductProducer;

    @Value("${kafka.topic.save}")
    private String insertTopic;

    @RequestMapping(value = "/")
    public String findAllProducts() {
        return "productsList";
    }

    @RequestMapping(value = "/productForm", method = RequestMethod.GET)
    public ModelAndView productForm(){
        return new ModelAndView("/productForm", "product", new Product());
    }

    @RequestMapping(value = "/saveProduct", method = RequestMethod.POST)
    public String saveProduct(@Valid @ModelAttribute("product")Product product, BindingResult bindingResult, ModelMap modelMap){
        if (bindingResult.hasErrors()){
            return "error";
        }
        modelMap.addAttribute("name", product.getName());
        modelMap.addAttribute("description", product.getDescription());
        modelMap.addAttribute("manufacturer", product.getManufacturer());
        modelMap.addAttribute("price", product.getPrice());
        modelMap.addAttribute("sku", product.getSku());

        kafkaProductProducer.send(product, insertTopic);

        return "productsList";
    }
}
