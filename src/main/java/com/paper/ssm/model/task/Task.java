package com.paper.ssm.model.task;

import com.paper.ssm.model.Model;
import com.paper.ssm.model.structure.Node;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 开启一次采集任务
 * @author ZengYuan
 */
@Getter
@Setter
public class Task extends Model {

    /**
     * Task与Cube是M:1的关系：即指定采集任务使用的是哪种模型
     */
    private Integer nodeId;
    private Node node;
    /**
     * Task与Bind是1：M的关系：即指定采集任务包含有多个Bind
     */
    List<Bind> bindCubeList;
    List<Bind> bindDataList;

}
