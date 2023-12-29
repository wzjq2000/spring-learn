package com.example.clientdemo.config;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    // 配置 RestTemplate
    @Bean
    public RestTemplate restTemplate(HttpComponentsClientHttpRequestFactory factory){
        return new RestTemplate(factory);
    }

//    @Bean
//    public ClientHttpRequestFactory simpleClientHttpRequestFactory(){
//        // 创建一个 httpCilent 简单工厂
//        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
//        // 设置连接超时
//        factory.setConnectTimeout(15000);
//        // 设置读取超时
//        factory.setReadTimeout(5000);
//        return factory;
//    }


    @Bean
    public HttpComponentsClientHttpRequestFactory httpClientFactory(){
        // 创建 HttpClient 实例
        HttpClient httpClient = HttpClientBuilder.create().build();

        // 创建 HttpComponentsClientHttpRequestFactory 实例，并设置 HttpClient
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(httpClient);

        return factory;
    }
}