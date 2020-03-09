package com.paper.ssm.model.dataPlane;


import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

/**
 * 数据流图 DFG，Multi-Level DAG的扁平化结果
 */
public class Graph extends Element {

    @JsonIgnore
    private List<Edge> innerEdgeList;
    private List<Data> innerDataList;


    public List<Edge> getInnerEdgeList() {
        return innerEdgeList;
    }

    public void setInnerEdgeList(List<Edge> innerEdgeList) {
        this.innerEdgeList = innerEdgeList;
    }

    public List<Data> getInnerDataList() {
        return innerDataList;
    }

    public void setInnerDataList(List<Data> innerDataList) {
        this.innerDataList = innerDataList;
    }
}
