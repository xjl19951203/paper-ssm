package com.paper.ssm.run.influx;


import com.paper.ssm.core.model.data.Query;
import com.paper.ssm.core.model.data.Data;
import org.influxdb.dto.QueryResult;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ZengYuan
 */
@Resource
public interface DataService {

    /**
     * d
     * @param query
     * @return
     */
    QueryResult select(Query query);

    /**
     * 添加记录
     *  @param record 消息
     * @return 返回id
     */
    long insert(Data record);

    /**
     * 批量添加记录
     * @param records 记录集合
     * @return 插入情况
     */
    int insert(List<Data> records);
}
