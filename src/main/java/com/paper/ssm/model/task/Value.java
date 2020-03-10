package com.paper.ssm.model.task;

import com.paper.ssm.model.Model;
import com.paper.ssm.model.structure.node.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @className: Value
 * @author: ZengYuan
 * @description:
 * @date 2020/3/10 10:35
 * @version: 1.0
 */
@Getter
@Setter
public class Value extends Model {

    /**
     * 一个Data实例对应一组Value数据实例，是1：M的关系
     */
    private Integer dataId;
    private Data data;
    /**
     * Value是属于某个采集任务的
     */
    private Integer taskId;
    private Task task;
    /**
     * 具体的值
     */
    private String value;

}
