package com.paper.ssm.model.dataPlane;

/**
 * 边结点，连接两个简单的Data结点
 * 1. left和right数据是
 */
public class Pipe extends Link {

    private Integer inputId;
    private Integer outputId;
    private Data input;
    // ruleList的规则集合来自于right端Data结点定义的
    private Data right;

    /**
     * 模板方法：按规范化方式，将左端结点内容向右端结点对齐，保障结点数据可用性
     */
    public void align() {

    }

    public Data getInput() {
        return input;
    }

    public void setInput(Data input) {
        this.input = input;
    }

    public Data getRight() {
        return right;
    }

    public void setRight(Data right) {
        this.right = right;
    }

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
