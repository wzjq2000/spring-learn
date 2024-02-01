package com.example.serverdemo.filter;

import org.springframework.boot.web.servlet.filter.OrderedFilter;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

//@Component
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Initiating");

    }

    public MyFilter() {
        System.out.println("Constructing");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("myFilter");
    }

//    @Override
//    public int getOrder() {
//        return -9901;
//    }
}
