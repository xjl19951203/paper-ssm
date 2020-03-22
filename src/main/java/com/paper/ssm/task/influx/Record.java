package com.paper.ssm.task.influx;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * @className: Record
 * @author: ZengYuan
 * @description:
 * @date 2020/3/22 11:09
 * @version: 1.0
 */
@Getter
@Setter
public class Record {

    /** 表 */
    private String measurement;
    /** 标签 */
    private Map<String, String> tags;
    /** 字段 */
    private Map<String, Object> fields;

}
