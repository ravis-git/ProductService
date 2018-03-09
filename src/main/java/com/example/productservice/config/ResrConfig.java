package com.example.productservice.config;

import com.example.productservice.rest.ProductApiImpl;
import com.my.experiments.microservices.chassis.config.JerseyConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;


/**
 * Created by ravipalakodeti on 8/11/17.
 */
@Component
@ApplicationPath("product-api")
@Slf4j
public class ResrConfig extends JerseyConfig {

    public ResrConfig() {
        log.info("..... Registering jersey");
        register(ProductApiImpl.class);
    }
}
