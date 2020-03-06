package com.paper.ssm.model.dataPlane;

public abstract class Edge extends Node {

    public static final Integer SERIES = 0x0001; // 串联关系，前者连向后者
    public static final Integer CONTAIN = 0x0010; // 从属关系，前者包含后者
    public static final Integer BELONG = 0x0100; // 从属关系，前者从属于后者

    protected Integer relation; // 左侧边界为0，右侧边界为1，暂无上下侧

}
