package com.nearsoft.products.libs;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue
    @Getter
    private int id;
    @Column(name = "name")
    @Getter
    @Setter
    private String name;
    @Column(name = "description")
    @Getter
    @Setter
    private String description;
    @Column(name = "sku")
    @Getter
    @Setter
    private String sku;
    @Column(name = "manufacturer")
    @Getter
    @Setter
    private String manufacturer;
    @Column(name = "price")
    @Getter
    @Setter
    private float price;
}
