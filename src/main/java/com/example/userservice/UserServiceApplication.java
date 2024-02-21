package com.example.userservice;

import com.example.userservice.entities.Rating;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaServer
@EnableFeignClients
public class UserServiceApplication {

    @Autowired
    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }
}
