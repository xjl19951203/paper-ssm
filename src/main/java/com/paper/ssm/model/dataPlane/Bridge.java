package com.paper.ssm.model.dataPlane;

/**
 * 连接两个 Cube
 */
public class Bridge extends Link{

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
}
