package com.example.springcode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.springcode.service","com.example.springcode.processor"})
public class SpringCodeApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCodeApplication.class, args);
    }

}
