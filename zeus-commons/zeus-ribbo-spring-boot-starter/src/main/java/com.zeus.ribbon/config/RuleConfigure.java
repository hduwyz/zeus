package com.zeus.ribbon.config;

import com.alibaba.cloud.nacos.ribbon.NacosServer;
import com.netflix.loadbalancer.IRule;
import com.zeus.ribbon.rule.VersionIsolationRule;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

public class RuleConfigure {
    @Bean
    @ConditionalOnClass(NacosServer.class)
    @ConditionalOnMissingBean
    public IRule versionIsolationRule() {
        return new VersionIsolationRule();
    }
}
