package com.paper.ssm.model.normalize;

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

    private String label;
    private String value;

}
