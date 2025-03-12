package com.pro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan(basePackages = "com.pro.models") 
@ComponentScan(basePackages = "com.pro") 
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}