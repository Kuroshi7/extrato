//package com.ibolt.extrato.config;
//
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//
//import javax.sql.DataSource;
//
//public class DataSourceConfig {
//    @Bean(name = "filemakerDataSource")
//    @ConfigurationProperties("spring.datasource.filemaker")
//    public DataSource filemakerDataSource() {
//        return DataSourceBuilder.create().build();
//    }
//}
