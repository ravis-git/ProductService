package com.example.productservice.repositories;

import com.example.productservice.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by ravipalakodeti on 8/11/17.
 */
public interface ProductRepository extends CrudRepository<Product, String> {

    Product findByName(String name);
//    List<Product> findByLastSku(String sku);
}
