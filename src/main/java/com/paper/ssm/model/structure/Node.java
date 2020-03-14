package com.paper.ssm.model.structure;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 结点型元素
 *
 * 子类：
 * a. Data
 * b. Cube
 * @author ZengYuan
 */
@Getter
@Setter
public class Node extends Component {


    /** 最小粒度结点 */
    public static final Integer SINGLE_TYPE = 0;
    /** 复合体结点 */
    public static final Integer COMPLEX_TYPE = 1;

    /** 复合结点还是单元结点 */
    private Integer type;
    /** 返回时排除掉这个字段 */
    /** @JsonIgnore */
    private List<Pipe> innerPipeList;
    /** 返回时排除掉这个字段 */
    /** @JsonIgnore */
    private List<Pipe> nextPipeList;
    /** 从属的内左侧集合 */
    private List<Node> innerNodeList;
    /** 同级的外右侧集合 */
    private List<Node> nextNodeList;
    private Integer graphId;
    private Graph graph;
}
