package com.nearsoft.products.model;

import com.nearsoft.products.libs.kafka.producer.KafkaProductProducer;
import com.nearsoft.products.libs.model.Product;
import com.nearsoft.products.model.listener.GetAllProductsListener;
import com.nearsoft.products.model.service.ProductService;
import com.nearsoft.products.model.listener.SaveProductListener;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest
public class ModelApplicationTests {

    @Value("${kafka.topic.save}")
    private String insertTopic;

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = webAppContextSetup(this.wac).build();
    }

    @Autowired
    private ProductService productService;

    @Autowired
    private KafkaProductProducer kafkaProductProducer;

    @Autowired
    private SaveProductListener saveProductListener;

    @Autowired
    private GetAllProductsListener getAllProductsListener;

    private TestRestTemplate testRestTemplate = new TestRestTemplate();;

    @Test
    public void testInsertNewProduct() {
        Product product = Product.builder().name("Name").description(String.valueOf(System.currentTimeMillis()))
                .manufacturer("Manufacturer").sku("SKU").price(0.0).build();
        productService.save(product);
        assertThat(product).hasFieldOrPropertyWithValue("name", "Name");
    }

    @Test
    public void testFindAllProducts() {
        Product product = Product.builder().name("Name").description(String.valueOf(System.currentTimeMillis()))
                .manufacturer("Manufacturer").sku("SKU").price(0.0).build();
        productService.save(product);
        assertThat(productService.findAll()).first().hasFieldOrPropertyWithValue("name", "Name");
    }

    @Test
    public void testSendReceiveSaveProduct() throws InterruptedException {
        Product product = Product.builder().id(1).name("Name").description(String.valueOf(System.currentTimeMillis())).sku("SKU")
                .manufacturer("Manufacturer").price(0.0).build();
        kafkaProductProducer.send(product, insertTopic);
        saveProductListener.getLatch().await(10000, TimeUnit.MILLISECONDS);
        assertThat(saveProductListener.getLatch().getCount()).isEqualTo(0);
    }

    @Test
    public void testGellAllProducts() throws Exception {
        Product product = Product.builder().name("Name").description(String.valueOf(System.currentTimeMillis()))
                .manufacturer("Manufacturer").sku("SKU").price(0.0).build();
        productService.save(product);
        mockMvc.perform(get("/productsList")).andExpect(status().isOk());
        getAllProductsListener.getLatch().await(10000, TimeUnit.MILLISECONDS);
        assertThat(getAllProductsListener.getLatch().getCount()).isEqualTo(0);
    }

}
