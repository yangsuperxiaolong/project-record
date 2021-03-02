package com.wlyang.record.log.dao;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@TableName("log_record")
@Data
public class LogRecordEntity {
    @TableId
    private Long id;
    @TableField
    private String username;
    @TableField
    private String operation;
    @TableField
    private String method;
    @TableField
    private String param;
    @TableField(value = "create_time")
    private Date creatTime;
}
