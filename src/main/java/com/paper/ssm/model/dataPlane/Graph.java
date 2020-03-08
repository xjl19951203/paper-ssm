package com.paper.ssm.model.dataPlane;


import java.util.List;

/**
 * 数据流图 DFG，Multi-Level DAG的扁平化结果
 */
public class Graph extends Element {

    private List<Data> inputList;
    private List<Data> outputList;

    public List<Data> getInputList() {
        return inputList;
    }

    public void setInputList(List<Data> inputList) {
        this.inputList = inputList;
    }

    public List<Data> getOutputList() {
        return outputList;
    }

    public void setOutputList(List<Data> outputList) {
        this.outputList = outputList;
    }
}
