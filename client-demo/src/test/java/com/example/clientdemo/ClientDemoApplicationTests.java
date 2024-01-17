package com.example.clientdemo;

import com.example.clientdemo.config.RestTemplateConfig;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
class ClientDemoApplicationTests {
    String url = "http://localhost:8080/";

    @Autowired
    RestTemplate restTemplate;
    @Test
    void restTemplateTest() {

//        String result = restTemplate.getForObject(url, String.class, "");
        ResponseEntity<String> result = restTemplate.getForEntity(url, String.class, "");

        System.out.println(result);

//        JSONObject jsonObject = new JSONObject();
//        ResponseEntity<JSONObject> jsonObjectResponseEntity = restTemplate.postForEntity(url, jsonObject, JSONObject.class);


    }
}
