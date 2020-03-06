package com.paper.ssm.model.dataPlane;

import java.util.List;

/**
 * 组结点
 * 1. 组结点的inputList是组内数据结点构成的DAG中，最左侧的结点inputList构成的集合
 * 2. 组结点的outputList是组内数据结点构成的DAG中，最右侧的结点outputList构成的集合
 */
public class GroupNode extends Node {

    @Override
    public void setOutputList(List<Node> outputList) {
        super.setOutputList(outputList);
    }
}
