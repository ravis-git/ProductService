package com.example.productservice.model;

import com.example.productservice.AbstractTestParent;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import com.example.productservice.model.exception.ProductCreationException;

import java.util.List;


/**
 * Created by ravipalakodeti on 8/10/17.
 */
@Slf4j
public class ProductBuilderTest extends AbstractTestParent{

    /*
    * Have a test case for domain entities like Product to ensure that these cannot be 'invalid'
    * eg: Make sure that each product has a validation that makes sure fields like name, sku and cost are
    *       set to there are no surprises in the future
    * */

    @Test(expected = ProductCreationException.class)
    public void testModelProductBuilderNameSKuAndCostRequired() {

        /*
        * a product at a minimum should have name, sku and cost.
        * If any of these are missing, throw a ProductCreationException with the message
        * */

        final Product product = ProductBuilder.build();
    }

    @Test
    public void testModelProductCreation() {
        //provide name and SKU and cost
        final Product product = ProductBuilder.build(
                p -> {
                    p.setName("Joke");
                    p.setSku("ORGNL");
                    p.setDescription("A joke that is original and inexpensive");
                    p.setCost(9.99F);
                }
        );
        assertThat("Cost are required", product, is(notNullValue()));
    }

    @Test
    public void testCreateHundredDummyProducts() {
        List<Product> productList = ProductBuilder.createHundredDummyProducts();
        assertThat(productList.size(), is(equalTo(100)));
        productList.stream().map(p -> p.toString()).forEachOrdered(System.out::println);
    }
}
