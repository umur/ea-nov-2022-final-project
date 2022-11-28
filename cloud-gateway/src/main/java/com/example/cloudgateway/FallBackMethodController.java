package com.example.cloudgateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//Our Circut breaker fallback method
@RestController
public class FallBackMethodController {

    @GetMapping("/commentServiceFallBack")
    public String userServiceFallBackMethod(){
        return "Comments Service is taking longer than " +
                "Expected, please try again later";
    }

    @GetMapping("/ratingServiceFallBack")
    public String departmentServiceFallBackMethod(){
        return "Rating Service is taking longer than " +
                "Expected, please try again later";
    }
}
