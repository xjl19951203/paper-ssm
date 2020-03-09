package com.paper.ssm.model.normalize.chains;

/**
 * 规则链父类，是个链表
 */
public abstract class Chain {

    protected Chain next;


    public abstract void execute();

}
