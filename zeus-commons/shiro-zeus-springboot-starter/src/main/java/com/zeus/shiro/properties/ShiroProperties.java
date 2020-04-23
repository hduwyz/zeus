package com.zeus.shiro.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Setter
@Getter
@ConfigurationProperties(prefix = "client")
public class ShiroProperties {

    /**
     * 各应用的appKey
     */
    private String appKey;
    /**
     * 远程服务URL地址
     */
    private String remoteServiceUrl;
    /**
     * 登录地址
     */
    private String loginUrl;
    /**
     * 登录成功后，默认重定向到的地址
     */
    private String successUrl = "/";
    /**
     * 未授权重定向到的地址
     */
    private String unauthorizedUrl;
    /**
     * session id 域名
     */
    private String cookieDomain;
    /**
     * session id 路径
     */
    private String cookiePath = "/";
    /**
     * cookie中的session id名称
     */
    private String sessionId = "sid";
    /**
     * cookie中的remember me名称
     */
    private String rememberMeId = "rememberMe";
    /**
     * 过滤器 name=filter-ref;name=filter-ref
     */
    private String filters;
    /**
     * 过滤器链 格式 url=filters;url=filters
     */
    private String filterChainDefinitions = "/**=anon";
}
