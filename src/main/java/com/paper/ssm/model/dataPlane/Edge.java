package com.paper.ssm.model.dataPlane;

public class Edge extends Link {

    public static final Integer INPUT_DIRECTION = 1; // 输入方向的边
    public static final Integer OUTPUT_DIRECTION = 0; // 输出方向的边

    private Integer graphId;
    private Integer dataId;
    private Integer direction; // 左侧边界为1，右侧边界为0，暂无上下侧


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
