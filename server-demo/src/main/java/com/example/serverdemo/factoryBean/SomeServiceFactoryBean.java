package com.example.serverdemo.factoryBean;

import com.example.serverdemo.service.SomeService;
import com.example.serverdemo.service.impl.SomeServiceImpl;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.cglib.proxy.Factory;
import org.springframework.stereotype.Component;


@Component
public class SomeServiceFactoryBean implements FactoryBean<SomeService> {
    @Override
    public SomeService getObject() throws Exception {
        return new SomeServiceImpl();
    }

    @Override
    public Class<?> getObjectType() {
        return SomeService.class;
    }
}
