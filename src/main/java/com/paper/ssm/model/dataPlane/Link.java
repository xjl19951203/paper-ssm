package com.paper.ssm.model.dataPlane;

/**
 * 连接型元素
 * 1. 两个端点，从左到由连接
 *
 * 子类：
 * a. Pipe
 * b. Edge
 * c. Bridge
 * d. Beam
 *
 */
public abstract class Link extends Element {

    public static final Integer INPUT_DIRECTION = 1; // 输入方向的边
    public static final Integer OUTPUT_DIRECTION = 0; // 输出方向的边
    public static final Integer INSIDE_RELATION = 1; // 从属关系
    public static final Integer OUTSIDE_RELATION = 0; // 同级串联关系
}
