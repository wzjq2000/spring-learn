package org.example.autoconfigure;


import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.example.datasource.TestDataSource;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@AutoConfigureAfter(value = {DruidDataSourceAutoConfigure.class})
public class DatasourceAutoConfigure {

    @Bean
    public DataSource testDataSource(DataSource druidDataSource){
        return new TestDataSource(druidDataSource);
    }
}
