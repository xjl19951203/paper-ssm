package com.paper.ssm.model.instantiate;

import com.paper.ssm.model.Model;
import com.paper.ssm.model.structure.Node;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 工艺过程实例化
 * @author ZengYuan
 */
@Getter
@Setter
public class Instance extends Model {

    /**
     * Task与Node是M:1的关系：即指定采集任务使用的是哪种模型
     */
    private Integer nodeId;
    private Node node;
    /**
     * Task与Bind是1：M的关系：即指定采集任务包含有多个Bind
     */
    List<Bind> bindList;

}
