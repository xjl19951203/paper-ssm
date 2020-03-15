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
public class Pipe extends Component {

    /** 复合结点的pipe：虚线 */
    public static final Integer COMPLEX_STYLE = 0;
    /** 不可再分结点的pipe：实线 */
    public static final Integer SINGLE_STYLE = 1;
    /** 左内侧边界结点的pipe：粗线 */
    public static final Integer EDGE_STYLE = 2;
    public static final int NEXT_TYPE = 1;
    public static final int CHILD_TYPE= 2;
    public static final int PARENT_TYPE= 3;

    protected Integer style;
    private Integer type;
    private Integer inputId;
    private Integer outputId;

}
