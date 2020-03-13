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

    /** 同级串联关系 */
    public static final Integer NOT_INNER = 0;
    /** 从属关系 */
    public static final Integer IS_INNER = 1;
    /**  输入侧的内边（同级串联不关注这个属性）*/
    public static final Integer INNER_INPUT_SIDE= 1;
    /** 输出侧的内边（同级串联不关注这个属性） */
    public static final Integer INNER_OUTPUT_SIDE = 0;
    /** 复合结点的pipe：虚线 */
    public static final Integer DOTTED_LINE = 0;
    /** 不可再分结点的pipe：实线 */
    public static final Integer SOLID_LINE = 1;
    /** 左内侧边界结点的pipe：粗线 */
    public static final Integer BOLD_LINE = 2;
    private Integer line;
    private Integer side;
    private Integer inner;
    private Integer inputId;
    private Integer outputId;
    private Node input;
    /**  ruleList的规则集合来自于right端Data结点定义的 */
    private Node right;

}
