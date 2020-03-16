package com.paper.ssm.model.normalize;

import com.paper.ssm.model.Model;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 规则链，与规则库构建关联关系
 * @author ZengYuan
 */
@Getter
@Setter
public class Chain extends Model {

    private List<Link> linkList;
    /** 不关注次序 */
    private List<Rule> ruleList;
}
