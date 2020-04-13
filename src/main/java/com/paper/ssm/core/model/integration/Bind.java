package com.paper.ssm.core.model.integration;

import com.paper.ssm.core.model.Model;
import com.paper.ssm.core.model.normalize.Information;
import com.paper.ssm.core.model.structure.Node;
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

    /** 最高优先级，表明该结点不需要继承上层的规则 */
    public static final int LEVEL_0 = 0;

    private Integer processId;
    private Integer informationId;
    private Integer nodeId;
    private Information information;
    private Node node;
    /** 绑定关系的优先级 */
    private Integer priority;

}
