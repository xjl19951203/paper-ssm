package com.paper.ssm.model.controlPlane.norm;

public abstract class Norm {

    /**
     * 该“执行方法”在结点实例在实现规范化处理时，会被调用
     * 所有规范化子类，都需要实现这个方法
     */
    public abstract void execute();
}
