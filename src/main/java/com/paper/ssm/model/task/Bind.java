package com.paper.ssm.model.task;

import com.paper.ssm.model.Model;
import com.paper.ssm.model.normalize.Rule;
import com.paper.ssm.model.structure.node.Cube;
import com.paper.ssm.model.structure.node.Data;
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

    public static final Integer BIND_DATA_FLAG = 0;
    public static final Integer BIND_CUBE_FLAG = 1;
    private Integer taskId;
    private Integer ruleId;
    private Integer cubeId;
    private Integer dataId;
    private Rule rule;
    private Cube cube;
    private Data data;
    private Integer flag;

}
