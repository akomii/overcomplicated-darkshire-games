package org.example.potato.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class EndpointController {
    @GetMapping("/hello")
    public User sayHello() {
        return new User(1, "username", "password");
    }
    
    public static void main(String[] args) {
        SpringApplication.run(EndpointController.class, args);
    }
}
