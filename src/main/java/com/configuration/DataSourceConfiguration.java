package com.configuration;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Component
//@PropertySource("classpath:druidJDBC.properties")
public class DataSourceConfiguration {

//    @Value("${driver}")
//    private String driver;
//
//    @Value("${url}")
//    private String url;
//
//    @Value("${username}")
//    private String username;
//
//    @Value("${password}")
//    private String password;
//
//    @Value("${initialSize}")
//    private int initialSize;
//
//    @Value("${maxActive}")
//    private int maxActive;
//
//    @Value("${maxWait}")
//    private int maxWait;

    @Bean("mysqlProperties")
    public Properties mysqlProperty() throws IOException {
        Properties properties = new Properties();
        InputStream resourceAsStream = DataSourceConfiguration.class.getClassLoader().getResourceAsStream("druidJDBC.properties");
        properties.load(resourceAsStream);
        return properties;
    }

//    @Bean("dataSource")
//    public DataSource getDataSource(){
//        DruidDataSource druidDataSource = new DruidDataSource();
//        druidDataSource.setDriverClassName(driver);
//        druidDataSource.setUrl(url);
//        druidDataSource.setUsername(username);
//        druidDataSource.setPassword(password);
//        druidDataSource.setInitialSize(initialSize);
//        druidDataSource.setMaxActive(maxActive);
//        druidDataSource.setMaxWait(maxWait);
//        return druidDataSource;
//    }

    @Resource(name = "mysqlProperties")
    private Properties mysqlProperties;

    @Bean("dataSource")
    public DataSource getDataSource() throws Exception {
        return DruidDataSourceFactory.createDataSource(mysqlProperties);
    }

    @Resource(name = "dataSource")
    private DataSource dataSource;

    @Bean("jdbcTemplates")
    public JdbcTemplate getJdbcTemplate(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        return jdbcTemplate;
    }

}
