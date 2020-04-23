package com.zeus.uaa.config;

import com.zeus.db.config.DefaultMybatisPlusConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author zlt
 * @date 2018/12/10
 */
@Configuration
@MapperScan({"com.zeus.db.mapper*"})
public class MybatisPlusConfig extends DefaultMybatisPlusConfig {

}
