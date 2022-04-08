package com.example.springcode;

import com.example.springcode.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringCodeApplication implements CommandLineRunner {
    @Autowired
    @Qualifier(value = "sonService")
    private BaseService baseService;
    public static void main(String[] args) {
        SpringApplication.run(SpringCodeApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        baseService.say();
    }
}
