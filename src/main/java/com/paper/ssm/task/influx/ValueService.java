package com.paper.ssm.task.influx;


import com.paper.ssm.task.Query;
import com.paper.ssm.task.Value;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ZengYuan
 */
@Resource
public interface ValueService {

    /**
     * d
     * @param query
     * @return
     */
    List<Value> select(Query query);

    /**
     * 添加记录
     *  @param record 消息
     * @return 返回id
     */
    long insert(Value record);

    /**
     * 批量添加记录
     * @param records 记录集合
     * @return 插入情况
     */
    int insert(List<Value> records);
}
