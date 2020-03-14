package com.paper.ssm.model.task;

import com.paper.ssm.model.Model;
import com.paper.ssm.model.normalize.Chain;
import com.paper.ssm.model.structure.Node;
import lombok.Getter;
import lombok.Setter;

/**
 * @className: Bind
 * @author: ZengYuan
 * @description: 规则绑定，构建 Rule与 Node 之间的关系
 * @date 2020/3/9 21:40
 * @version: 1.0
 */
@Getter
@Setter
public class Bind extends Model {

    private Integer taskId;
    private Integer chainId;
    private Integer nodeId;
    private Chain chain;
    private Node node;

}
