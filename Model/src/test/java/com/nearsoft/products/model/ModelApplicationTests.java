package com.nearsoft.products.model;

import com.nearsoft.products.libs.Product;
import com.nearsoft.products.model.repository.ProductRepository;
import com.nearsoft.products.model.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ModelApplicationTests {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testInsertNewProduct() {
        Product product = Product.builder().name("Name").description("Description")
                .manufacturer("Manufacturer").sku("SKU").price(0.0).build();
        productService.save(product);
        assertThat(product).hasFieldOrPropertyWithValue("name", "Name");
    }

    @Test
    public void testFindAllProducts() {
        Product product = Product.builder().name("Name").description("Description")
                .manufacturer("Manufacturer").sku("SKU").price(0.0).build();
        productService.save(product);
        assertThat(productService.findAll()).first().hasFieldOrPropertyWithValue("name", "Name");
        ;
    }

}
