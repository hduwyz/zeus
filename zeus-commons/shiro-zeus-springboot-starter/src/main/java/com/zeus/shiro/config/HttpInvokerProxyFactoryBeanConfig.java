package com.zeus.shiro.config;

import com.zeus.shiro.properties.ShiroProperties;
import com.zeus.shiro.remote.RemoteServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;

public class HttpInvokerProxyFactoryBeanConfig {

    @Autowired
    private ShiroProperties shiroProperties;

    @Bean
    public HttpInvokerProxyFactoryBean remoteService(){
        HttpInvokerProxyFactoryBean httpInvokerProxyFactoryBean = new HttpInvokerProxyFactoryBean();
        httpInvokerProxyFactoryBean.setServiceUrl(shiroProperties.getSuccessUrl());
        httpInvokerProxyFactoryBean.setServiceInterface(RemoteServiceInterface.class);
        return httpInvokerProxyFactoryBean;
    }
}
