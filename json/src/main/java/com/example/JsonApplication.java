package com.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class JsonApplication {

    public static void main(String[] args) throws JsonProcessingException {
        SpringApplication.run(JsonApplication.class, args);
    }

}
