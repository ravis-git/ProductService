package com.example.productservice.service;


import com.example.productservice.model.Product;
import com.example.productservice.model.ProductBuilder;
import com.example.productservice.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * Created by ravipalakodeti on 8/11/17.
 */
@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository repository;

    @Override
    public void saveProductIntoDatabase(Product product) {
        repository.save(product.addIdToProduct());
    }
}
