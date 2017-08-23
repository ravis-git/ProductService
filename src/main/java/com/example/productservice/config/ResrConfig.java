package com.example.productservice.config;

import com.example.productservice.rest.ProductApiImpl;
import lombok.extern.slf4j.Slf4j;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

/**
 * Created by ravipalakodeti on 8/11/17.
 */
@Component
@ApplicationPath("api")
@Slf4j
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        log.info("..... Registering jersey");
        register(ProductApiImpl.class);
    }
}
