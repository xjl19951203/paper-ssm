package com.paper.ssm.model.structure;

import lombok.Getter;
import lombok.Setter;

/**
 * @className: Line
 * @author: ZengYuan
 * @description:
 * @date 2020/3/14 15:30
 * @version: 1.0
 */
@Getter
@Setter
public class Line extends Component{

    /** 复合结点的pipe：虚线 */
    public static final Integer COMPLEX_STYLE = 0;
    /** 不可再分结点的pipe：实线 */
    public static final Integer SINGLE_STYLE = 1;
    /** 左内侧边界结点的pipe：粗线 */
    public static final Integer EDGE_STYLE = 2;

    protected Integer style;
}
