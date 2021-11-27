package com.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("com")
@Import({DataSourceConfiguration.class,RedisDataSourceConfig.class})
public class SpringConfiguration {

    @Bean("json")
    public ObjectMapper save1(){
        return new ObjectMapper();
    }
}
