package com.paper.ssm.model.dataPlane;

public abstract class Edge extends Node {

    public static final Integer POSITIVE_DIRECTION = 1; // 左侧连向右侧
    public static final Integer NEGATIVE_DIRECTION = 0; // 右侧连向左侧
    public static final Integer INSIDE_RELATION = 1; // 从属关系
    public static final Integer OUTSIDE_RELATION = 0; // 同级串联关系

    protected Integer direction; // 左侧边界为0，右侧边界为1，暂无上下侧
    protected Integer relation; // 左侧边界为0，右侧边界为1，暂无上下侧

    public Integer getDirection() {
        return direction;
    }

    public void setDirection(Integer direction) {
        this.direction = direction;
    }

    public Integer getRelation() {
        return relation;
    }

    public void setRelation(Integer relation) {
        this.relation = relation;
    }


}
