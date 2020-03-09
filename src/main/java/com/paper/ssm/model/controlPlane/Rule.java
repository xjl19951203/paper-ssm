package com.paper.ssm.model.controlPlane;

import com.paper.ssm.model.Bean;

/**
 * Rule与Value之间 1:M的关系，一条规则可以被多个Value使用，每个Value对某一类型的Rule只允许关联一条
 */
public abstract class Rule extends Bean {


    /**
     * 该“执行方法”在结点实例在实现规范化处理时，会被调用
     * 所有规范化子类，都需要实现这个方法
     */
    public abstract void execute();
}
