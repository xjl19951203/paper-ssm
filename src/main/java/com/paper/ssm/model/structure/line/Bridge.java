package com.paper.ssm.model.structure.line;

import com.paper.ssm.model.structure.node.Cube;
import lombok.Getter;
import lombok.Setter;

/**
 * 连接两个 Cube
 * @author ZengYuan
 */
@Getter
@Setter
public class Bridge extends Line {

    /** 区别作为从属关系还是同级串联关系 */
    private Integer inner;
    /** 从属关系下，区别作为输入还是输出桥梁；*/
    private Integer side;
    private Integer inputId;
    private Integer outputId;
    private Cube input;
    private Cube output;

}
