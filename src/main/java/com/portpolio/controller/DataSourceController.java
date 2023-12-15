//package com.portpolio.controller;
//
//import com.portpolio.config.DataSourceContext;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class DataSourceController {
//
//    @GetMapping("/switchDataSource")
//    public String switchDataSource(@RequestParam String name) {
//        DataSourceContext.setCurrentDataSource(name);
//        return "Data source switched to: " + name;
//    }
//}
