package com.paper.ssm.model.dataPlane;

import java.util.List;

/**
 * Multi-Level DAG
 */
public class Cube extends Node {

    private List<Cube> inputList;
    private List<Cube> outputList;
    private Graph graph;

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

    public Graph getGraph() {
        return graph;
    }

    public void setGraph(Graph graph) {
        this.graph = graph;
    }
}
