package com.micro.services.product.content.service.impl.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan({"com.micro.services.product.content.service.impl"})
public class ProductContentServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductContentServiceApplication.class, args);
    }

}
