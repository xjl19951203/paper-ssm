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

    /** 标签类规则：地点、型号、 */
    public final static int LABEL_TYPE = 1;
    /** 数据类规则：取值范围、 */
    public final static int NUMERIC_TYPE = 2;

    private Integer type;
    private String label;
    private String value;

}
