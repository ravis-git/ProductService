package com.example.productservice.model.exception;

/**
 * Created by ravipalakodeti on 8/11/17.
 */
public class ProductCreationException extends RuntimeException {
    public ProductCreationException(String message) {
        super(message);
    }
}