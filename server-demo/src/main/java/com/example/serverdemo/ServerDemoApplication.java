package com.example.serverdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServerDemoApplication {

//    private static final Logger log = LoggerFactory.getLogger(ServerDemoApplication.class);


    public static void main(String[] args) {
        SpringApplication.run(ServerDemoApplication.class, args);
//        log.info("This is for test");

    }
}
