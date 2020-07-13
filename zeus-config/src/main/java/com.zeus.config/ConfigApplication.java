package com.zeus.config;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@NacosPropertySource(dataId = "springboot2-nacos-config", autoRefreshed = true)
@SpringBootApplication
@RestController
@RefreshScope
public class ConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigApplication.class, args);
    }

//    @NacosValue(value = "${nacos.test.propertie:123}", autoRefreshed = true)
    @Value("${nacos.test.propertie:123}")
    private String testProperties;

    public void setTestProperties(String testProperties) {
        this.testProperties = testProperties;
    }

    @GetMapping("/test")
    public String test(){
        return testProperties;
    }
}
