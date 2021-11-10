package com.training.rest.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class RestClientApplication {

    public static void main(final String[] args) {
        SpringApplication.run(RestClientApplication.class,
                              args);
    }


}
