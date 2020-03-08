package com.paper.ssm.model.dataPlane;

public abstract class Edge extends Link {

    public static final Integer INPUT_DIRECTION = 1; // 输入方向的边
    public static final Integer OUTPUT_DIRECTION = 0; // 输出方向的边

    protected Integer direction; // 左侧边界为1，右侧边界为0，暂无上下侧

    public Integer getDirection() {
        return direction;
    }

    public void setDirection(Integer direction) {
        this.direction = direction;
    }

}
