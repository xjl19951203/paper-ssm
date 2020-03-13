package com.paper.ssm.influx;


import com.paper.ssm.model.task.Message;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ZengYuan
 */
@Resource
public interface MessageService{

    /**
     * 添加记录
     *  @param record 消息
     * @return 返回id
     */
    long insert(Message record);

    /**
     * 批量添加记录
     * @param records 记录集合
     * @return 插入情况
     */
    int insert(List<Message> records);
}
