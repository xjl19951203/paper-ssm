package com.paper.ssm.model.dataPlane;


import java.util.List;

/**
 * 数据流图 DFG，Multi-Level DAG的扁平化结果
 */
public class Graph extends Element {

    private Integer cubeId;
    private Cube cube;
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

    public Integer getCubeId() {
        return cubeId;
    }

    public void setCubeId(Integer cubeId) {
        this.cubeId = cubeId;
    }

    public Cube getCube() {
        return cube;
    }

    public void setCube(Cube cube) {
        this.cube = cube;
    }
}
