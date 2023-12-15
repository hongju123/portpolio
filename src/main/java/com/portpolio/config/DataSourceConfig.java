//package com.portpolio.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
//
//import javax.sql.DataSource;
//import java.util.HashMap;
//import java.util.Map;
//
//@Configuration
//public class DataSourceConfig {
//
//    @Bean
//    public DataSource dynamicDataSource(DataSource ocoDataSource, DataSource whatDataSource) {
//        AbstractRoutingDataSource routingDataSource = new DynamicDataSource();
//
//        Map<Object, Object> dataSourceMap = new HashMap<>();
//        dataSourceMap.put("oco", ocoDataSource);
//        dataSourceMap.put("what", whatDataSource);
//
//        routingDataSource.setTargetDataSources(dataSourceMap);
//        routingDataSource.setDefaultTargetDataSource(ocoDataSource);
//
//        return routingDataSource;
//    }
//
//    // OcoDataSource 및 WhatDataSource는 변경하지 않고 그대로 사용
//}
