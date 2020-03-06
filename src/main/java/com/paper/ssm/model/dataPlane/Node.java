package com.paper.ssm.model.dataPlane;

import com.paper.ssm.model.controlPlane.config.Config;
import com.paper.ssm.model.controlPlane.method.Method;
import com.paper.ssm.model.controlPlane.norm.Norm;

import java.util.ArrayList;
import java.util.List;

/**
 * 结点父类：有向无环图（DAG）
 * （1）子类：
 *  a. 数据结点；
 *  b. 边结点；
 *  c. 组结点；
 *
 * 1. DAG基于邻接表实现
 * 2. 与常规DAG不同，Graph有可能是更大的Graph的结点
 * 3. XML <=> DAG，二者互相转换
 */
public abstract class Node {
    /**
     * 结点数据面
     */
    protected Integer id; // 结点唯一标识符
    protected String title; // 结点名称
    protected List<Node> inputList; // 结点输入数组
    protected List<Node> outputList; // 结点输出数组
    /**
     * 结点控制面
     */
    protected List<Norm> normList; // 结点规范化
    protected List<Config> configList; // 结点配置
    protected List<Method> methodList; // 结点赋能

    public void addInput(Node node) {
        if (this.inputList == null) {
            this.inputList = new ArrayList<>();
        }
        this.inputList.add(node);
    }

    public void addOutput(Node node) {
        if (this.outputList == null) {
            this.outputList = new ArrayList<>();
        }
        this.outputList.add(node);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Node> getInputList() {
        return inputList;
    }

    public void setInputList(List<Node> inputList) {
        this.inputList = inputList;
    }

    public List<Node> getOutputList() {
        return outputList;
    }

    public void setOutputList(List<Node> outputList) {
        this.outputList = outputList;
    }

    public List<Norm> getNormList() {
        return normList;
    }

    public void setNormList(List<Norm> normList) {
        this.normList = normList;
    }

    public List<Config> getConfigList() {
        return configList;
    }

    public void setConfigList(List<Config> configList) {
        this.configList = configList;
    }

    public List<Method> getMethodList() {
        return methodList;
    }

    public void setMethodList(List<Method> methodList) {
        this.methodList = methodList;
    }


}
