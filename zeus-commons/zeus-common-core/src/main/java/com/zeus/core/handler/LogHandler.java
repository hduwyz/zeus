package com.zeus.core.handler;

import com.zeus.core.handler.annotation.LogInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.MethodIntrospector;
import org.springframework.core.annotation.AnnotatedElementUtils;

import java.lang.reflect.Method;
import java.util.Map;

public class LogHandler implements ApplicationContextAware, SmartInitializingSingleton, DisposableBean {
    private static final Logger logger = LoggerFactory.getLogger(LogHandler.class);

    @Override
    public void destroy(){
    }

    @Override
    public void afterSingletonsInstantiated() {
        //init LogHandler Repository(for method)
        initLogHandlerMethodRepository(applicationContext);
    }

    private void initLogHandlerMethodRepository(ApplicationContext applicationContext){
        if (applicationContext == null){
            return;
        }
        // init job handler from method
        String[] beanDefinitionNames = applicationContext.getBeanNamesForType(Object.class, false, true);
        for (String beanDefinitionName : beanDefinitionNames){
            Object bean = applicationContext.getBean(beanDefinitionName);
            Map<Method, LogInfo> annotatedMethods = null;
            try {
                annotatedMethods = MethodIntrospector.selectMethods(bean.getClass(),
                        new MethodIntrospector.MetadataLookup<LogInfo>() {
                            @Override
                            public LogInfo inspect(Method method) {
                                return AnnotatedElementUtils.findMergedAnnotation(method, LogInfo.class);
                            }
                        });
            } catch (Throwable ex){
                logger.error("LogInfo method-LogHandler resolve error for bean[" + beanDefinitionName + "].", ex);
            }
            if (annotatedMethods==null || annotatedMethods.isEmpty()){
                continue;
            }

            for (Map.Entry<Method, LogInfo> methodLogInfoEntry : annotatedMethods.entrySet()){
                Method method = methodLogInfoEntry.getKey();
                LogInfo logInfo = methodLogInfoEntry.getValue();
                if (logInfo == null){
                    continue;
                }
                String name = logInfo.value();
                if (name.trim().length() == 0){
                    throw new RuntimeException("LogInfo method-Loghandler name invalid, for[" + bean.getClass() + "#" + method.getName() + "] .");
                }

            }
        }
    }
    // ---------------------- applicationContext ----------------------
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public static ApplicationContext getApplicationContext(){
        return applicationContext;
    }
}
