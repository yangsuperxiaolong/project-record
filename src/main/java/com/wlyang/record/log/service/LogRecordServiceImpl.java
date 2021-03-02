package com.wlyang.record.log.service;

import com.mysql.cj.log.Log;
import com.wlyang.record.log.dao.LogRecordEntity;
import com.wlyang.record.log.dao.LogRecordMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LogRecordServiceImpl implements LogRecordService {
    @Resource
    private LogRecordMapper logRecordMapper;


    @Override
    public void insert(LogRecordEntity entity) {
        logRecordMapper.insert(entity);
    }
}
