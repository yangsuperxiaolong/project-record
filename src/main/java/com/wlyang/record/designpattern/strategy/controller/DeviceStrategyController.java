package com.wlyang.record.designpattern.strategy.controller;

import com.wlyang.record.designpattern.strategy.service.DeviceStrategySerivce;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController("/strategy/device")
public class DeviceStrategyController {
    @Resource
    private DeviceStrategySerivce deviceStrategySerivce;
    @RequestMapping("process")
    public void process(){
        deviceStrategySerivce.processDeivceSn();
    }
}
