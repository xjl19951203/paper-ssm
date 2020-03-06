package com.paper.ssm.model.dataPlane;

import java.util.List;

/**
 * 图结点，基于Edge，构建与内部结点（Data、Graph）的联系
 */
public class Graph extends Node {

    /**
     * 结点群组的左侧结点边界，是DAG的发始端点集合
     */
    private List<GraphEdge> leftGraphList;
    private List<GraphEdge> rightGraphList;
    /**
     * 结点群组的右侧结点边界，是DAG的终止端点集合
     */
    private List<DataEdge> leftDataList;
    private List<DataEdge> rightDataList;

    public List<GraphEdge> getLeftGraphList() {
        return leftGraphList;
    }

    public void setLeftGraphList(List<GraphEdge> leftGraphList) {
        this.leftGraphList = leftGraphList;
    }

    public List<GraphEdge> getRightGraphList() {
        return rightGraphList;
    }

    public void setRightGraphList(List<GraphEdge> rightGraphList) {
        this.rightGraphList = rightGraphList;
    }

    public List<DataEdge> getLeftDataList() {
        return leftDataList;
    }

    public void setLeftDataList(List<DataEdge> leftDataList) {
        this.leftDataList = leftDataList;
    }

    public List<DataEdge> getRightDataList() {
        return rightDataList;
    }

    public void setRightDataList(List<DataEdge> rightDataList) {
        this.rightDataList = rightDataList;
    }
}
