package com.zeus.shiro.config;

import com.zeus.shiro.ClientAuthenticationFilter;
import com.zeus.shiro.ClientRealm;
import com.zeus.shiro.ClientSessionDAO;
import com.zeus.shiro.ClientShiroFilterFactoryBean;
import com.zeus.shiro.properties.ShiroProperties;
import com.zeus.shiro.remote.RemoteServiceInterface;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.session.mgt.eis.JavaUuidSessionIdGenerator;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.MethodInvokingFactoryBean;
import org.springframework.context.annotation.Bean;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.Map;

public class DefaultSecurityHandlerConfig {

    @Autowired
    ShiroProperties shiroProperties;

    @Autowired
    private RemoteServiceInterface remoteService;

    @Bean
    public ClientRealm remoteRealm(){
        ClientRealm clientRealm = new ClientRealm();
        clientRealm.setAppKey(shiroProperties.getAppKey());
        clientRealm.setCachingEnabled(false);
        clientRealm.setRemoteService(remoteService);
        return clientRealm;
    }

    @Bean
    public JavaUuidSessionIdGenerator sessionIdGenerator(){
        return new JavaUuidSessionIdGenerator();
    }

    @Bean
    public SimpleCookie sessionIdCookie(){
        SimpleCookie simpleCookie = new SimpleCookie(shiroProperties.getSessionId());
        simpleCookie.setHttpOnly(true);
        simpleCookie.setMaxAge(-1);
        simpleCookie.setDomain(shiroProperties.getCookieDomain());
        simpleCookie.setPath(shiroProperties.getCookiePath());
        return simpleCookie;
    }

    @Bean
    public SimpleCookie rememberMeCookie(){
        SimpleCookie simpleCookie = new SimpleCookie(shiroProperties.getRememberMeId());
        simpleCookie.setHttpOnly(true);
        simpleCookie.setMaxAge(2592000);
        simpleCookie.setDomain(shiroProperties.getCookieDomain());
        simpleCookie.setPath(shiroProperties.getCookiePath());
        return simpleCookie;
    }

    @Bean
    public CookieRememberMeManager rememberMeManager(){
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        cookieRememberMeManager.setCookie(rememberMeCookie());
        cookieRememberMeManager.setCipherKey(Base64.decode("4AvVhmFLUs0KTA3Kprsdag=="));
        return cookieRememberMeManager;
    }

    @Bean
    public ClientSessionDAO sessionDAO(){
        ClientSessionDAO clientSessionDAO = new ClientSessionDAO();
        clientSessionDAO.setAppKey(shiroProperties.getAppKey());
        clientSessionDAO.setSessionIdGenerator(sessionIdGenerator());
        clientSessionDAO.setRemoteService(remoteService);
        return clientSessionDAO;
    }

    @Bean
    public DefaultWebSessionManager sessionManager() {
        DefaultWebSessionManager defaultWebSessionManager = new DefaultWebSessionManager();
        defaultWebSessionManager.setSessionIdCookie(sessionIdCookie());
        defaultWebSessionManager.setSessionIdCookieEnabled(true);
        defaultWebSessionManager.setSessionDAO(sessionDAO());
        defaultWebSessionManager.setSessionValidationSchedulerEnabled(false);
        defaultWebSessionManager.setDeleteInvalidSessions(false);
        return defaultWebSessionManager;
    }

    @Bean
    public DefaultWebSecurityManager securityManager(){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(remoteRealm());
        securityManager.setSessionManager(sessionManager());
        securityManager.setRememberMeManager(rememberMeManager());
        return securityManager;
    }

    @Bean
    public MethodInvokingFactoryBean methodInvokingFactoryBean(){
        MethodInvokingFactoryBean methodInvokingFactoryBean = new MethodInvokingFactoryBean();
        methodInvokingFactoryBean.setStaticMethod("org.apache.shiro.SecurityUtils.setSecurityManager");
        methodInvokingFactoryBean.setArguments(securityManager());
        return methodInvokingFactoryBean;
    }

    @Bean
    public ClientAuthenticationFilter clientAuthenticationFilter(){
        return new ClientAuthenticationFilter();
    }

    @Bean
    public ClientShiroFilterFactoryBean shiroFilter(){
        ClientShiroFilterFactoryBean shiroFilter = new ClientShiroFilterFactoryBean();
        shiroFilter.setSecurityManager(securityManager());
        shiroFilter.setLoginUrl(shiroProperties.getLoginUrl());
        shiroFilter.setSuccessUrl(shiroProperties.getSuccessUrl());
        shiroFilter.setUnauthorizedUrl(shiroProperties.getUnauthorizedUrl());
        Map<String, Filter> map = new HashMap<String, Filter>();
        map.put("authc", clientAuthenticationFilter());
        shiroFilter.setFilters(map);
        shiroFilter.setFiltersStr(shiroProperties.getFilters());
        shiroFilter.setFilterChainDefinitionsStr(shiroProperties.getFilterChainDefinitions());
        return shiroFilter;
    }

    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor(){
        return new LifecycleBeanPostProcessor();
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(){
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager());
        return authorizationAttributeSourceAdvisor;
    }
}
