package com.example.serverdemo;

import com.example.serverdemo.service.SomeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ServerDemoApplication {

//    private static final Logger log = LoggerFactory.getLogger(ServerDemoApplication.class);


    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ServerDemoApplication.class, args);
        SomeService bean = context.getBean(SomeService.class);
        bean.someService();
//        log.info("This is for test");

    }
}
