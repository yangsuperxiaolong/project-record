package com.wlyang.record.log.controller;

import com.wlyang.record.log.annotation.LogRecordAnnotation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogRecordTestController {

    @LogRecordAnnotation(value = "操作牛逼呢")
    @RequestMapping(value = "log/record/test")
    public void testLogRecord() {
        return;
    }
}
