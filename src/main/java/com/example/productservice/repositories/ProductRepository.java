package com.example.productservice.repositories;

import com.example.productservice.model.Product;
import org.springframework.data.repository.CrudRepository;


/**
 * Created by ravipalakodeti on 8/11/17.
 */
public interface ProductRepository extends CrudRepository<Product, String> {

    Product findByName(String name);
}
