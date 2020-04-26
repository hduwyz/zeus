package com.zeus.uaa.config;

import com.zeus.db.config.DefaultMybatisPlusConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"com.zeus.uaa.mapper.*"})
public class MybatisPlusConfig extends DefaultMybatisPlusConfig {

}
