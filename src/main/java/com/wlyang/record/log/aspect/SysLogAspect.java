package com.wlyang.record.log.aspect;

import com.alibaba.fastjson.JSON;
import com.wlyang.record.log.annotation.LogRecordAnnotation;
import com.wlyang.record.log.dao.LogRecordEntity;
import com.wlyang.record.log.service.LogRecordService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Date;

@Aspect
@Component
public class SysLogAspect {

    @Autowired
    private LogRecordService logRecordService;

    //定义切点 @Pointcut
    //在注解的位置切入代码
    @Pointcut("@annotation(com.wlyang.record.log.annotation.LogRecordAnnotation)")
    public void logPointCut() {
    }

    //切面 配置通知
    @AfterReturning("logPointCut()")
    public void saveSysLog(JoinPoint joinPoint) {
        System.out.println("切面。。。。。");
        //保存日志
        LogRecordEntity logRecordEntity = new LogRecordEntity();

        //从切面织入点处通过反射机制获取织入点处的方法
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        //获取切入点所在的方法
        Method method = signature.getMethod();

        //获取操作
        LogRecordAnnotation myLog = method.getAnnotation(LogRecordAnnotation.class);
        if (myLog != null) {
            String value = myLog.value();
            logRecordEntity.setOperation(value);//保存获取的操作
        }

        //获取请求的类名
        String className = joinPoint.getTarget().getClass().getName();
        //获取请求的方法名
        String methodName = method.getName();
        logRecordEntity.setMethod(className + "." + methodName);

        //请求的参数
        Object[] args = joinPoint.getArgs();
        //将参数所在的数组转换成json
        String params = JSON.toJSONString(args);

        logRecordEntity.setParam(params);

        logRecordEntity.setCreatTime(new Date());

        //调用service保存SysLog实体类到数据库
        logRecordService.insert(logRecordEntity);
    }

}