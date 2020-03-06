package com.paper.ssm.model.dataPlane;

/**
 * 边结点，连接两个简单的Data结点
 * 1. left和right数据是
 */
public class Edge extends Node {

    /**
     * Mysql表结构相关
     */
    private Integer leftId;
    private Integer rightId;
    /**
     * 模型相关
     */
    private Data left;
    private Data right;

    /**
     * 模板方法：按规范化方式，将左端结点内容向右端结点对齐，保障结点数据可用性
     */
    public void align() {

    }

    public Integer getLeftId() {
        return leftId;
    }

    public void setLeftId(Integer leftId) {
        this.leftId = leftId;
    }

    public Integer getRightId() {
        return rightId;
    }

    public void setRightId(Integer rightId) {
        this.rightId = rightId;
    }

    public Data getRight() {
        return right;
    }

    public void setRight(Data right) {
        this.right = right;
    }

    public Data getLeft() {
        return left;
    }

    public void setLeft(Data left) {
        this.left = left;
    }
}
