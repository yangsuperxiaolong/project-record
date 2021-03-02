package com.wlyang.record.designpattern.strategy.service.impl;

import com.wlyang.record.designpattern.strategy.annotation.DeviceTypeAnno;
import com.wlyang.record.designpattern.strategy.bean.DeviceType;
import com.wlyang.record.designpattern.strategy.service.DeviceSnProcessStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@DeviceTypeAnno(DeviceType.DEVICE_TWO)
public class DeviceTwoSnProcess implements DeviceSnProcessStrategy {
    @Override
    public void processDeviceSn() {
        log.info("处理设备-2 的序列号");
    }
}
