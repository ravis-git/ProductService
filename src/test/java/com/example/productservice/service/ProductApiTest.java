package com.example.productservice.service;

import com.example.productservice.AbstractTestParent;
import com.example.productservice.model.Product;
import com.example.productservice.model.ProductBuilder;
import com.example.productservice.repositories.ProductRepository;
import org.junit.Ignore;
import org.junit.Test;

import javax.inject.Inject;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

/**
 * Created by ravipalakodeti on 8/11/17.
 */

public class ProductApiTest extends AbstractTestParent {

    @Inject
    ProductRepository productRepository;

    @Test
    @Ignore
    public void checkSaveProductToMongoDB() {
        List<Product> productList = ProductBuilder.createHundredDummyProducts();
        assertThat(productList.size(), is(equalTo(100)));
        productList.stream()
                .forEach(product -> productRepository.save(product));
    }
}
