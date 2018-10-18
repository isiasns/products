package com.nearsoft.products.view;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.nearsoft.products")
@SpringBootApplication
public class ViewApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(ViewApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ViewApplication.class);
    }

}
