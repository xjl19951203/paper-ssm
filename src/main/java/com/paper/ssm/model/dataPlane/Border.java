package com.paper.ssm.model.dataPlane;

public class Border extends Node {

    public static final Integer LEFT_SIDE = 0;
    public static final Integer LEFT_RIGHT = 1;

    private Integer side; // 左侧边界为0，右侧边界为1，暂无上下侧
    private Integer parentId; // 边界联系的所属图主键
    private Integer dataId; // 边界联系的所属图内Data结点主键
    private Integer graphId; // 边界联系的所属图内Graph结点主键
    private Graph parent; // 边界关联所属图
    private Data data; // 边界关联内部Data结点
    private Graph graph; // 边界关联内部Graph结点

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

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getDataId() {
        return dataId;
    }

    public void setDataId(Integer dataId) {
        this.dataId = dataId;
    }

    public Graph getParent() {
        return parent;
    }

    public void setParent(Graph parent) {
        this.parent = parent;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Graph getGraph() {
        return graph;
    }

    public void setGraph(Graph graph) {
        this.graph = graph;
    }
}
