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
