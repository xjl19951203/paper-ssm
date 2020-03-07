package com.paper.ssm.model.dataPlane;

import java.util.List;

/**
 * 图结点，基于Edge，构建与内部结点（Data、Graph）的联系
 */
public class Graph extends Node {

    /**
     * 结点群组的左侧结点边界，是DAG的发始端点集合
     */
    private List<GGEdge> leftGGEdgeList;
    private List<GDEdge> leftGDEdgeList;
    /**
     * 结点群组的右侧结点边界，是DAG的终止端点集合
     */
    private List<GGEdge> rightGGEdgeList;
    private List<GDEdge> rightGDEdgeList;

    public List<GGEdge> getLeftGGEdgeList() {
        return leftGGEdgeList;
    }

    public void setLeftGGEdgeList(List<GGEdge> leftGGEdgeList) {
        this.leftGGEdgeList = leftGGEdgeList;
    }

    public List<GGEdge> getRightGGEdgeList() {
        return rightGGEdgeList;
    }

    public void setRightGGEdgeList(List<GGEdge> rightGGEdgeList) {
        this.rightGGEdgeList = rightGGEdgeList;
    }

    public List<GDEdge> getLeftGDEdgeList() {
        return leftGDEdgeList;
    }

    public void setLeftGDEdgeList(List<GDEdge> leftGDEdgeList) {
        this.leftGDEdgeList = leftGDEdgeList;
    }

    public List<GDEdge> getRightGDEdgeList() {
        return rightGDEdgeList;
    }

    public void setRightGDEdgeList(List<GDEdge> rightGDEdgeList) {
        this.rightGDEdgeList = rightGDEdgeList;
    }
}
