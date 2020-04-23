package com.zeus.shiro.config;

import org.springframework.context.annotation.Import;

@Import({DefaultSecurityHandlerConfig.class, HttpInvokerProxyFactoryBeanConfig.class})
public class DefaultResourceServerConf {
}
