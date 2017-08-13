package com.example.productservice.rest;


import com.example.productservice.model.Product;
import com.example.productservice.model.ProductBuilder;
import com.example.productservice.rest.responses.Create;
import com.example.productservice.service.ProductServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by ravipalakodeti on 8/11/17.
 */
@Component
@Path("/products")
@Slf4j
public class ProductApiImpl implements ProductApi {

    @Inject
    ProductServiceImpl productService;

    @Override
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Product getProduct(@PathParam("id") String id) {
        return  ProductBuilder.build(
                p -> {
                    p.setName("Joke");
                    p.setSku("ORGNL");
                    p.setDescription("A joke that is original and inexpensive");
                    p.setCost(9.99F);
                }
        );
    }

//    @ApiOperation(value = "Create a new terminal")
//    @ApiResponses(value = {@ApiResponse(code = 201, message = "Terminal created successfully.",
//            response = StandardResponse.class)})
    @Override
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Create createNewProduct(@RequestBody Product product) {
        log.info("=====> product from request is : {}", product.toString());
        productService.saveProductIntoDatabase(product);
        return Create.builder().responseCode(201)
                .resource("/".concat(product.getSku()))
                .creationTime(DateTimeFormatter.ISO_DATE_TIME.format(LocalDateTime.now()))
                .build();
    }
}
