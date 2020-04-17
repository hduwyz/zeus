package com.zeus.core.config;

import com.nepxion.banner.BannerConstant;
import com.nepxion.banner.Description;
import com.nepxion.banner.LogoBanner;
import com.taobao.text.Color;
import com.zeus.core.constant.CommonConstant;
import com.zeus.core.utils.CustomBanner;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Banner初始化
 */
public class BannerInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        if (!(applicationContext instanceof AnnotationConfigApplicationContext)) {
            LogoBanner logoBanner = new LogoBanner(BannerInitializer.class, "/banner/logo.txt", "Welcome to cmdi", 1, 6, new Color[5], true);
            CustomBanner.show(logoBanner, new Description(BannerConstant.VERSION + ":", CommonConstant.PROJECT_VERSION, 0, 1)
                    , new Description("cmdi:", "中国移动设计院浙江分院开发组", 0, 1)
                    , new Description("Info:", "http://www.cmdi.chinamobile.com/", 0, 1)
            );
        }
    }
}
