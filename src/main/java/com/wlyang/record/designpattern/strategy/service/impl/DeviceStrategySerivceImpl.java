package com.wlyang.record.designpattern.strategy.service.impl;

import com.wlyang.record.designpattern.strategy.service.DeviceStrategySerivce;
import org.springframework.stereotype.Service;

@Service
public class DeviceStrategySerivceImpl implements DeviceStrategySerivce {
    @Override
    public void processDeivceSn() {
        System.out.println("ss");
    }
}




