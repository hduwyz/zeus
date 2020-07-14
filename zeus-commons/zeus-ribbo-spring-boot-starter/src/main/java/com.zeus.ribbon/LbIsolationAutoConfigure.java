package com.zeus.ribbon;

import com.zeus.core.constant.ConfigConstants;
import com.zeus.ribbon.config.RuleConfigure;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.netflix.ribbon.RibbonClients;

/**
 * 自定义负载均衡配置
 */
@ConditionalOnProperty(value = ConfigConstants.CONFIG_RIBBON_ISOLATION_ENABLED, havingValue = "true")
@RibbonClients(defaultConfiguration = {RuleConfigure.class})
public class LbIsolationAutoConfigure {

}
