package com.paper.ssm.model.structure;

import lombok.Getter;
import lombok.Setter;

/**
 * @className: Edge
 * @author: ZengYuan
 * @description:
 * @date 2020/3/14 15:30
 * @version: 1.0
 */
@Setter
@Getter
public class Edge extends Line{

    /**  输入侧的内边（同级串联不关注这个属性）*/
    public static final Integer INPUT_SIDE= 1;
    /** 输出侧的内边（同级串联不关注这个属性） */
    public static final Integer OUTPUT_SIDE = 0;

    private Integer side;
    private Integer parentId;
    private Integer childId;

}
