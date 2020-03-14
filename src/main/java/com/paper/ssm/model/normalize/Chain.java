package com.paper.ssm.model.normalize;

import com.paper.ssm.model.Model;
import com.paper.ssm.model.normalize.rules.Rule;
import lombok.Getter;
import lombok.Setter;

/**
 * 规则链，与规则库构建关联关系
 * @author ZengYuan
 */
@Getter
@Setter
public class Chain extends Model {

    private Integer ruleId;
    private Rule rule;
    private Integer nextId;
    private Chain next;

}
