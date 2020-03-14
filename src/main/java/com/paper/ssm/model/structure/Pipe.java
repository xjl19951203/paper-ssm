package com.paper.ssm.model.structure;

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

}
