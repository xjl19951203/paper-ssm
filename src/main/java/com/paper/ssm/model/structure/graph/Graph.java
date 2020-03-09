package com.paper.ssm.model.structure.graph;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.paper.ssm.model.structure.Component;
import com.paper.ssm.model.structure.line.Edge;
import com.paper.ssm.model.structure.node.Data;
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

    @JsonIgnore
    private List<Edge> innerEdgeList;
    private List<Data> innerDataList;

}
