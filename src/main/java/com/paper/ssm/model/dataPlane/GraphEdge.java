package com.paper.ssm.model.dataPlane;

public class GraphEdge extends Edge {

    private Integer graphId; // 边界联系的所属图内Graph结点主键
    private Graph graph; // 边界关联内部Graph结点

    public Integer getGraphId() {
        return graphId;
    }

    public void setGraphId(Integer graphId) {
        this.graphId = graphId;
    }

    public Graph getGraph() {
        return graph;
    }

    public void setGraph(Graph graph) {
        this.graph = graph;
    }
}
