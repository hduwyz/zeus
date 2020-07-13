//package com.zeus.demo.config;
//
//import com.zeus.core.handler.SessionCounterListener;
//import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@SuppressWarnings("unchecked")
//@Configuration
//public class SpringMvcConfig implements WebMvcConfigurer {
//
//    @Bean
//    public ServletListenerRegistrationBean servletListenerRegistrationBean(){
//        ServletListenerRegistrationBean servletListenerRegistrationBean = new ServletListenerRegistrationBean();
//        servletListenerRegistrationBean.setListener(new SessionCounterListener());
//        return servletListenerRegistrationBean;
//    }
//}
