package com.paper.ssm.model.structure.Line;

import com.paper.ssm.model.structure.node.Cube;

/**
 * 连接两个 Cube
 */
public class Bridge extends Line {

    // 区别作为从属关系还是同级串联关系
    private Integer inner;
    // 从属关系下，区别作为输入还是输出桥梁；
    private Integer side;
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

    public Integer getInner() {
        return inner;
    }

    public void setInner(Integer inner) {
        this.inner = inner;
    }

    public Integer getSide() {
        return side;
    }

    public void setSide(Integer side) {
        this.side = side;
    }
}
