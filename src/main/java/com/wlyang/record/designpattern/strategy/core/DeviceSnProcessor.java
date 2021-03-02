package com.wlyang.record.designpattern.strategy.core;

import com.wlyang.record.designpattern.strategy.annotation.DeviceTypeAnno;
import com.wlyang.record.designpattern.strategy.bean.DeviceType;
import com.wlyang.record.designpattern.strategy.service.DeviceSnProcessStrategy;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 策略核心功能,获取所有策略注解的类型
 */
@Component
public class DeviceSnProcessor implements ApplicationContextAware {
    /**
     * 获取所有的策略Beanclass
     *
     * @param applicationContext
     * @throws BeansException
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        //获取所有策略注解的Bean
        Map<String, Object> deviceTypeProcessMap = applicationContext.getBeansWithAnnotation(DeviceTypeAnno.class);
        deviceTypeProcessMap.forEach((k, v) -> {
            Class<DeviceSnProcessStrategy> deviceSnProcessStrategyClass = (Class<DeviceSnProcessStrategy>) v.getClass();
            DeviceType type = deviceSnProcessStrategyClass.getAnnotation(DeviceTypeAnno.class).value();
            //将class加入map中,type作为key
            DeviceSnProcessContext.deviceSnProcessBeanMap.put(type, deviceSnProcessStrategyClass);
        });
    }
}