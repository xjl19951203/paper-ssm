package com.paper.ssm.model.dataPlane;

/**
 * 连接型元素
 * 1. 两个端点，从左到由连接
 */
public class Link extends Element {

    protected Integer inputId;
    protected Integer outputId;

    public Integer getInputId() {
        return inputId;
    }

    public void setInputId(Integer inputId) {
        this.inputId = inputId;
    }

    public Integer getOutputId() {
        return outputId;
    }

    public void setOutputId(Integer outputId) {
        this.outputId = outputId;
    }
}
