package com.wlyang.record;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@SpringBootApplication
@ImportResource(locations = {"classpath:common.xml"})
@ComponentScan(basePackages = "com.wlyang.record.*")
@RestController
@Slf4j
public class SpringBootProjectApplication {

    public static void main(String[] args) {
        log.info("springboot项目启动");
        SpringApplication.run(SpringBootProjectApplication.class, args);
    }

    @Resource
    private JmsTemplate jmsTemplate;

    @RequestMapping("/send")
    public String send(@RequestParam("msg") String msg) {
        jmsTemplate.convertAndSend("myQueue", msg);
        return "【发送消息】：" + msg;
    }

    @PostMapping("/logTest")
    public void logTest() {
        log.info("发送消息");
        log.error("发送错误消息");
    }
}
