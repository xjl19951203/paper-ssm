package com.paper.ssm.model.dataPlane;

public class Border extends Node {

    public static final Integer LEFT_SIDE = 0;
    public static final Integer LEFT_RIGHT = 1;

    private Integer side; // 左侧边界为0，右侧边界为1，暂无上下侧
    private Integer graphId; // 边界联系的所属图主键
    private Integer nodeId; // 边界联系的所属图内结点主键，可能Data，也可能是小Graph
    private Graph graph;
    private Node node;

    public Integer getSide() {
        return side;
    }

    public void setSide(Integer side) {
        this.side = side;
    }

    public Integer getGraphId() {
        return graphId;
    }

    public void setGraphId(Integer graphId) {
        this.graphId = graphId;
    }

    public Integer getNodeId() {
        return nodeId;
    }

    public void setNodeId(Integer nodeId) {
        this.nodeId = nodeId;
    }

    public Graph getGraph() {
        return graph;
    }

    public void setGraph(Graph graph) {
        this.graph = graph;
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }
}
