package com.wlyang.record.designpattern.strategy.core;

import com.wlyang.record.designpattern.strategy.bean.DeviceType;
import com.wlyang.record.designpattern.strategy.service.DeviceSnProcessStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class DeviceSnProcessContext {
    @Autowired
    private ApplicationContext applicationContext;
    //存放所有策略类Bean的map
    public static Map<DeviceType, Class<DeviceSnProcessStrategy>> deviceSnProcessBeanMap = new ConcurrentHashMap<>();

    public DeviceSnProcessStrategy getDeviceSnProcessStrategy(DeviceType type) {
        Class<DeviceSnProcessStrategy> strategyClass = deviceSnProcessBeanMap.get(type);

        if (strategyClass == null) {
            throw new IllegalArgumentException("没有这种设备");
        }
        //从容器中获取对应的策略Bean
        return applicationContext.getBean(strategyClass);
    }
}