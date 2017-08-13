package com.example.productservice.rest.responses;

import lombok.Builder;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * Created by ravipalakodeti on 8/12/17.
 */
@Builder
@Setter
public class Create {

    public int responseCode;
    public String resource;
    public String creationTime;
}
