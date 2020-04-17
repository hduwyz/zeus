//package com.zeus.demo.config;
//
//import com.zeus.core.filter.ZeusLogFilter;
//import com.zeus.core.handler.LogHandler;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class LogConfig {
//    private Logger logger = LoggerFactory.getLogger(LogConfig.class);
//
//    @Bean
//    public LogHandler logHandler() {
//        logger.info(">>>>>>>>>>> logInfo config init.");
//        LogHandler logHandler = new LogHandler();
//        return logHandler;
//    }
//
//    @Bean
//    public FilterRegistrationBean xxlSsoFilterRegistration() {
//
//        // xxl-sso, filter init
//        FilterRegistrationBean registration = new FilterRegistrationBean();
//
//        registration.setName("XxlSsoWebFilter");
//        registration.setOrder(1);
//        registration.addUrlPatterns("/*");
//        registration.setFilter(new ZeusLogFilter());
//
//        return registration;
//    }
//}
