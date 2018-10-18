package com.nearsoft.products.libs.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
    private double price;

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + "'" + ", name='" + name + "'" + ", description='" + description + "'"
                + ", sku='" + sku + "'" + ", manufacturer='" + manufacturer + "'" + ", price='" + price + "'" + "}";
    }
}
