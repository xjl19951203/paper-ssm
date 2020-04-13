package com.paper.ssm.core.model.integration;

import com.paper.ssm.core.model.Model;
import com.paper.ssm.core.model.structure.Node;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 工艺过程集成
 * @author ZengYuan
 */
@Getter
@Setter
public class Process extends Model {

    /**
     * Task与Node是M:1的关系：即指定采集任务使用的是哪种模型
     */
    private Integer nodeId;
    private Node node;
    List<Bind> bindList;

}
