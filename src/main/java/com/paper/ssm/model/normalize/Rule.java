package com.paper.ssm.model.normalize;

import com.paper.ssm.model.Model;
import lombok.Getter;
import lombok.Setter;

/**
 * 规则三元组模型
 * @author ZengYuan
 */
@Setter
@Getter
public class Rule extends Model {

    private String label;
    private String value;

}
