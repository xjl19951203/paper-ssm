package com.paper.ssm.model.dataPlane;

import java.util.List;

/**
 * Multi-Level DAG
 */
public class Cube extends Node {

    private List<Cube> inputList;
    private List<Cube> outputList;

    public List<Cube> getInputList() {
        return inputList;
    }

    public void setInputList(List<Cube> inputList) {
        this.inputList = inputList;
    }

    public List<Cube> getOutputList() {
        return outputList;
    }

    public void setOutputList(List<Cube> outputList) {
        this.outputList = outputList;
    }

}
