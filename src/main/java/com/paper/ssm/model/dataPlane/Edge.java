package com.paper.ssm.model.dataPlane;

public abstract class Edge extends Node {

    public static final Integer LEFT_SIDE = 0;
    public static final Integer LEFT_RIGHT = 1;

    protected Integer side; // 左侧边界为0，右侧边界为1，暂无上下侧
    protected Integer parentId; // 边界联系的所属图主键
    protected Graph parent; // 边界关联所属图

    public Integer getSide() {
        return side;
    }

    public void setSide(Integer side) {
        this.side = side;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Graph getParent() {
        return parent;
    }

    public void setParent(Graph parent) {
        this.parent = parent;
    }
}
