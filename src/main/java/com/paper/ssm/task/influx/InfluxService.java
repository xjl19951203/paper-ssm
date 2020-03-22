package com.paper.ssm.task.influx;

import org.influxdb.InfluxDB;
import org.influxdb.dto.QueryResult;

import javax.annotation.Resource;

/**
 * @className: InfluxService
 * @author: ZengYuan
 * @description:
 * @date 2020/3/22 11:05
 * @version: 1.0
 */
@Resource
public interface InfluxService {

    /**
     * d
     * @return InfluxDB
     */
    InfluxDB connect();

    /**
     * 查询
     * @param command 查询参数
     * @return 查询结果集
     */
    QueryResult selectByQuery(String command);

    /**
     * 插入记录
     * @param record 插入一条记录
     */
    void insert(Record record);
}
