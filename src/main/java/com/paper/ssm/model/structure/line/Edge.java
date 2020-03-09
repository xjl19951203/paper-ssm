package com.paper.ssm.model.structure.line;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ZengYuan
 */
@Getter
@Setter
public class Edge extends Line {

    private Integer graphId;
    private Integer dataId;
    /**
     * edge不同于bridge，只有从属关系，因此side只表征输入侧还是输出侧
     */
    private Integer side;

}
