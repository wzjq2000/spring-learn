package com.example.serverdemo;

import com.example.serverdemo.service.SomeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class  ServerDemoApplication {

//    private static final Logger log = LoggerFactory.getLogger(ServerDemoApplication.class);


    public static void main(String[] args) {
//        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "/Users/andy/SelfLearn/JavaProjects2.0/spring-learn/server-demo");
        ConfigurableApplicationContext context = SpringApplication.run(ServerDemoApplication.class, args);
        context.getBean("kk");
        SomeService bean = context.getBean(SomeService.class);
        bean.someService();
//        log.info("This is for test");

    }
}
