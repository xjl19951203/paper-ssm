package com.paper.ssm.model.dataPlane;

public class Edge extends Link {

    private Integer graphId;
    private Integer dataId;
    // edge不同于bridge，只有从属关系，因此side只表征输入侧还是输出侧
    private Integer side;


    public Integer getDataId() {
        return dataId;
    }

    public void setDataId(Integer dataId) {
        this.dataId = dataId;
    }

    public Integer getGraphId() {
        return graphId;
    }

    public void setGraphId(Integer graphId) {
        this.graphId = graphId;
    }

    public Integer getSide() {
        return side;
    }

    public void setSide(Integer side) {
        this.side = side;
    }
}
