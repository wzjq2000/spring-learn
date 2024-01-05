//package com.example.serverdemo.filter;
//
//import org.springframework.boot.web.servlet.filter.OrderedFilter;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import java.io.IOException;
//
//@Component
//public class MyFilter implements OrderedFilter {
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        System.out.println("myFilter");
//    }
//
//    @Override
//    public int getOrder() {
//        return -9901;
//    }
//}
