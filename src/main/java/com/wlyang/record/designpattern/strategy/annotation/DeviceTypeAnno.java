package com.wlyang.record.designpattern.strategy.annotation;

import com.wlyang.record.designpattern.strategy.bean.DeviceType;

import java.lang.annotation.*;

@Target(ElementType.TYPE)  //作用在类上
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited  //子类可以继承此注解
public @interface DeviceTypeAnno {
    /**
     * 策略类型
     * @return
     */
    DeviceType value();
}
