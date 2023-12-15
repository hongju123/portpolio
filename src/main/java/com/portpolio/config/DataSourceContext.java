//package com.portpolio.config;
//
//public class DataSourceContext {
//    private static final ThreadLocal<String> currentDataSource = new ThreadLocal<>();
//
//    public static void setCurrentDataSource(String dataSource) {
//        currentDataSource.set(dataSource);
//    }
//
//    public static String getCurrentDataSource() {
//        return currentDataSource.get();
//    }
//
//    public static void clear() {
//        currentDataSource.remove();
//    }
//}