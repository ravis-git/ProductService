package com.example.productservice.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;

import java.util.UUID;

/**
 * Created by ravipalakodeti on 8/10/17.
 */
@Getter
@ToString
@Setter
@Accessors(chain = true)
public class Product {

    @Id
    private String id;
    private String name;
    private String sku;
    private String Description;
    private Float cost;
    private Boolean inStock = false;
    private String seller;
    // this shoule probably be a different domain that is stateless and calculates it?
    // private String[] availableInStoresNearYou;

    public Product addIdToProduct() {
        return this.setId(UUID.randomUUID().toString());
    }

}
