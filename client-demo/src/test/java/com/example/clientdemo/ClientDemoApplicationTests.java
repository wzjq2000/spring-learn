package com.example.clientdemo;

import com.example.clientdemo.config.RestTemplateConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
class ClientDemoApplicationTests {

    @Autowired
    RestTemplate restTemplate;
    @Test
    void restTemplateTest() {
        String result = restTemplate.getForObject("http://localhost:8080", String.class, "");
        System.out.println(result);
    }

    @Test
    void restTemplateTest2(){
    }

}
