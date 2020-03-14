package com.paper.ssm.model.normalize.rules;

import com.paper.ssm.model.Model;
import lombok.Getter;
import lombok.Setter;

/**
 * Rule与 Node 之间 M:N的关系，即某个结点Node的规则链，是与相关的Rule集合的Chain的并集
 * 并且该每一种类型的Chain只能存在一个，这里涉及要优先级的问题
 * @author ZengYuan
 */
@Setter
@Getter
public class Rule extends Model {

    public static final int DEFAULT_TYPE = 1;
    public static final int RANGE_TYPE = 2;
    public static final int TYPE_TYPE = 3;
    public static final int UNIT_TYPE = 4;

    /** 子类型标识符 */
    protected Integer type;
    private Integer defaultId;
    private Integer rangeId;
    private Integer typeId;
    private Integer unitId;

}
