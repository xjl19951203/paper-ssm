package com.paper.ssm.model.structure;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 数据流图 DFG，Multi-Level DAG的扁平化结果
 * @author ZengYuan
 */
@Getter
@Setter
public class Graph extends Component {

    /** 根节点*/
    private Node root;
    private List<Node> nodeList;
    private List<Pipe> pipeList;
    private List<Flow> flowList;

}
