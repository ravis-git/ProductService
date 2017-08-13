package com.example.productservice.rest;

import com.example.productservice.model.Product;
import com.example.productservice.rest.responses.Create;

/**
 * Created by ravipalakodeti on 8/11/17.
 */
public interface ProductApi {

    Product getProduct(String id);
    Create createNewProduct(Product product);
}
