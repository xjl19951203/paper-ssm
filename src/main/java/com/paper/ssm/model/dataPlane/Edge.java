package com.paper.ssm.model.dataPlane;

public class Edge extends Link {

    private Integer graphId;
    private Integer dataId;
    // edge不同于bridge，只有从属关系，因此direction只表征input还是output
    private Integer direction;


    public Integer getDirection() {
        return direction;
    }

    public void setDirection(Integer direction) {
        this.direction = direction;
    }

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
}
