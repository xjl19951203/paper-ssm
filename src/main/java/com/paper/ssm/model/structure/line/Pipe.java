package com.paper.ssm.model.structure.line;

import com.paper.ssm.model.structure.node.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 边结点，连接两个简单的Data结点
 * 1. left和right数据是
 * @author ZengYuan
 */
@Getter
@Setter
public class Pipe extends Line {

    private Integer inputId;
    private Integer outputId;
    private Data input;
    /**  ruleList的规则集合来自于right端Data结点定义的 */
    private Data right;

}
