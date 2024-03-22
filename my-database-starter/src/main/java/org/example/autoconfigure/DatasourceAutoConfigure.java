package org.example.outside;


import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import com.example.serverdemo.datasource.TestDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@AutoConfigureAfter(value = {DruidDataSourceAutoConfigure.class})
public class DatasourceAutoConfigure {

    @Bean
    @ConditionalOnMissingBean
    public DataSource testDataSource(DataSource druidDataSource){
        return new TestDataSource(druidDataSource);
    }
}
