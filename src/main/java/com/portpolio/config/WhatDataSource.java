//package com.portpolio.config;
//
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//import org.springframework.transaction.PlatformTransactionManager;
//
//import javax.sql.DataSource;
//import java.util.HashMap;
//
//@Configuration
//@EnableJpaRepositories(
//        basePackages = "com.portpolio.service.WhatSerivce.*",
//        entityManagerFactoryRef = "WhatEntityManger",
//        transactionManagerRef = "WhatTransactionManager"
//)
//public class WhatDataSource {
//
//    @Bean
//    public PlatformTransactionManager WhatTransactionManager() {
//
//        JpaTransactionManager transactionManager = new JpaTransactionManager();
//        transactionManager.setEntityManagerFactory(WhatEntityManger().getObject());
//
//        return transactionManager;
//    }
//
//    @Bean
//    public LocalContainerEntityManagerFactoryBean WhatEntityManger() {
//
//        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
//
//        em.setDataSource(whatData());
//        em.setPackagesToScan(new String[]{"com.portpolio.service.whatSerice"});
//        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
//
//        HashMap<String, Object> properties = new HashMap<>();
//        properties.put("hibernate.hbm2ddl.auto", "update");
//
//        em.setJpaPropertyMap(properties);
//
//        return em;
//    }
//
//    @Bean
//    public DataSource whatData() {
//        return DataSourceBuilder.create()
//                .driverClassName("com.mysql.cj.jdbc.Driver")
//                .url("jdbc:mysql://localhost:3306/what")
//                .username("root")
//                .password("1234")
//                .build();
//    }
//
//}