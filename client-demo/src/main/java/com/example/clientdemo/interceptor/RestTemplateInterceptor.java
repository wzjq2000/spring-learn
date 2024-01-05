package com.example.clientdemo.interceptor;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class RestTemplateInterceptor  implements ClientHttpRequestInterceptor {

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        HttpHeaders headers= request.getHeaders();
        headers.add("key","value");
        ClientHttpResponse response = execution.execute(request, body);
        return response;
    }
}
