package com.paper.ssm.model.dataPlane;

public class GGEdge extends Edge {

    private Integer g1Id;
    private Integer g2Id;
    private Graph g1;
    private Graph g2;

    public Integer getG1Id() {
        return g1Id;
    }

    public void setG1Id(Integer g1Id) {
        this.g1Id = g1Id;
    }

    public Integer getG2Id() {
        return g2Id;
    }

    public void setG2Id(Integer g2Id) {
        this.g2Id = g2Id;
    }

    public Graph getG1() {
        return g1;
    }

    public void setG1(Graph g1) {
        this.g1 = g1;
    }

    public Graph getG2() {
        return g2;
    }

    public void setG2(Graph g2) {
        this.g2 = g2;
    }
}
