package com.paper.ssm.model.dataPlane;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

/**
 * Multi-Level DAG
 */
public class Cube extends Node {

    @JsonIgnore  //返回时排除掉这个字段
    private List<Bridge> innerBridgeList;
    @JsonIgnore  //返回时排除掉这个字段
    private List<Bridge> nextBridgeList;
    private List<Cube> innerCubeList; // 从属的内左侧集合
    private List<Cube> nextCubeList; // 同级的外右侧集合
    private Integer graphId; //
    private Graph graph;


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

    public List<Cube> getNextCubeList() {
        return nextCubeList;
    }

    public void setNextCubeList(List<Cube> nextCubeList) {
        this.nextCubeList = nextCubeList;
    }

    public List<Bridge> getNextBridgeList() {
        return nextBridgeList;
    }

    public void setNextBridgeList(List<Bridge> nextBridgeList) {
        this.nextBridgeList = nextBridgeList;
    }

    public List<Bridge> getInnerBridgeList() {
        return innerBridgeList;
    }

    public void setInnerBridgeList(List<Bridge> innerBridgeList) {
        this.innerBridgeList = innerBridgeList;
    }

    public List<Cube> getInnerCubeList() {
        return innerCubeList;
    }

    public void setInnerCubeList(List<Cube> innerCubeList) {
        this.innerCubeList = innerCubeList;
    }
}
