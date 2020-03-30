package com.paper.ssm.model.instantiate;

import com.paper.ssm.model.Model;
import com.paper.ssm.model.structure.Flow;
import com.paper.ssm.model.structure.Node;
import com.paper.ssm.model.structure.Pipe;
import com.paper.ssm.model.structure.Point;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 数据流图 DFG，Multi-Level DAG的扁平化结果
 * @author ZengYuan
 */
@Getter
@Setter
public class Graph extends Model {

    /** 根节点*/
    private Node root;
    private List<Point> pointList;
    private List<Pipe> pipeList;
    private List<Flow> flowList;

}
