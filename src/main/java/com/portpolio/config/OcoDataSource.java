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
//
//import java.beans.JavaBean;
//import java.util.HashMap;
//
//@Configuration
//@EnableJpaRepositories(
//    basePackages = "com.portpolio.service.ocoSerivce.*", entityManagerFactoryRef = "firstEntityManger", 
//    transactionManagerRef = "firstTransactionManager")
//public class OcoDataSource {
//	@Primary
//    @Bean
//    public PlatformTransactionManager firstTransactionManager() {
//
//        JpaTransactionManager transactionManager = new JpaTransactionManager();
//        transactionManager.setEntityManagerFactory(firstEntityManger().getObject());
//
//        return transactionManager;
//    }
//	@Primary
//    @Bean
//    public LocalContainerEntityManagerFactoryBean firstEntityManger() {
//
//        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
//
//        em.setDataSource(ocoData());
//        em.setPackagesToScan(new String[] { "com.portpolio.service.ocoService" });
//        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
//
//        HashMap<String, Object> properties = new HashMap<>();
//        properties.put("hibernate.hbm2ddl.auto", "update");
//
//        em.setJpaPropertyMap(properties);
//
//        return em;
//    }
//	@Primary
//    @Bean
//    public DataSource ocoData() {
//        return DataSourceBuilder.create()
//                .driverClassName("com.mysql.cj.jdbc.Driver")
//                .url("jdbc:mysql://localhost:3306/oco")
//                .username("root")
//                .password("1234")
//                .build();
//    }
//
//}