package com.paper.ssm.model.dataPlane;

/**
 * 连接两个 Cube
 */
public class Bridge extends Link{

    // 区别作为从属关系还是同级串联关系
    private Integer relation;
    // 从属关系下，区别作为输入还是输出桥梁；
    // 同级关系下，区别左侧->右侧 方向连接， 还是反方向连接（同级下，通常默认1，默认左到右）
    private Integer direction;
    private Integer inputId;
    private Integer outputId;
    private Cube input;
    private Cube output;

    public Cube getInput() {
        return input;
    }

    public void setInput(Cube input) {
        this.input = input;
    }

    public Cube getOutput() {
        return output;
    }

    public void setOutput(Cube output) {
        this.output = output;
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

    public Integer getDirection() {
        return direction;
    }

    public void setDirection(Integer direction) {
        this.direction = direction;
    }

    public Integer getRelation() {
        return relation;
    }

    public void setRelation(Integer relation) {
        this.relation = relation;
    }
}
