package com.example.serverdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cglib.core.DebuggingClassWriter;

@SpringBootApplication
public class ServerDemoApplication {

//    private static final Logger log = LoggerFactory.getLogger(ServerDemoApplication.class);


    public static void main(String[] args) {
//        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "/Users/andy/SelfLearn/JavaProjects2.0/spring-learn/server-demo");
        SpringApplication.run(ServerDemoApplication.class, args);
//        log.info("This is for test");

    }
}
