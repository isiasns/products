package com.nearsoft.products.model.repository;

import com.nearsoft.products.libs.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
}
