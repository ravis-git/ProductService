package com.example.productservice.model;

import com.example.productservice.model.exception.ProductCreationException;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by ravipalakodeti on 8/11/17.
 */
public class ProductBuilder {

    static final List<String> names = Arrays
            .asList("car","train","computer","keyboard","phone","table","bottle","shelf","pen","book");
    static final SecureRandom random = new SecureRandom();
    static final List<String> sellers = Arrays.asList("Sell-Corp","Brick-Store","Ware-House","No-Tax","Re-Tailor");

    @FunctionalInterface
    public interface ProductSetter extends Consumer<Product>{}

    public static Product build(ProductSetter... productSetters) {
        final Product product = new Product();

        Stream.of(productSetters).forEach(
                p -> p.accept(product)
        );
        product.addIdToProduct();

        /**
         * Validate the business entity.
         * All the attributes that are part of the objec should be capable of being generated from the client application
         * otherwise, we run into an issue where a second web request object needs to be created.
         * A second validate method can additionally be used for validation after the object has been transformed
         * internal to the create funciton.
         */
        final boolean valid = (product.getName() == null || product.getName().isEmpty()
                                    || product.getSku() == null  || product.getSku().isEmpty()
                                    || (product.getCost() == null || product.getCost() < 0.0 ))
                                ? false
                                : true;

        if(!valid) throw new ProductCreationException("Name SKU and Cost are required for a product");
        return product;

    }

    // creating this method is an anti-pattern in live code, but makes scafolding easy in an experiment
    static public List<Product> createHundredDummyProducts() {
        return IntStream.range(0,100)
                .mapToObj(count -> ProductBuilder.build(
                        p -> {
                            p.setName(names.get(random.nextInt(10)))
                             .setSku(new BigInteger(50, random).toString())
                             .setSeller(sellers.get(random.nextInt(5)))
                             .setCost(random.nextFloat())
                             .setDescription("The greatest " + p.getName() + " in the hole world" )
                             .setInStock(random.nextBoolean());
                        }
                ))
                .collect(Collectors.toList());
    }

}
