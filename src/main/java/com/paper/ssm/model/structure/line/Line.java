package com.paper.ssm.model.structure.line;

import com.paper.ssm.model.structure.Component;
import lombok.Getter;
import lombok.Setter;

/**
 * 连接型元素
 * 1. 两个端点，从左到由连接
 *
 * 子类：
 * a. Pipe
 * b. Edge
 * c. Bridge
 * d. Beam
 *
 * @author ZengYuan
 */
@Getter
@Setter
public class Line extends Component {

    /** 同级串联关系 */
    public static final Integer NOT_INNER = 0;
    /** 从属关系 */
    public static final Integer IS_INNER = 1;
    /**  输入侧的内边（同级串联不关注这个属性）*/
    public static final Integer INNER_INPUT_SIDE= 1;
    /** 输出侧的内边（同级串联不关注这个属性） */
    public static final Integer INNER_OUTPUT_SIDE = 0;
}
