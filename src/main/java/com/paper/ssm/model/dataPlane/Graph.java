package com.paper.ssm.model.dataPlane;

import java.util.List;

/**
 * 组结点，基于DAG维护内部结点的联系和边界
 * 1. 组结点的inputList是组内数据结点构成的DAG中，最左侧的结点inputList构成的集合
 * 2. 组结点的outputList是组内数据结点构成的DAG中，最右侧的结点outputList构成的集合
 */
public class Graph extends Node {

    private List<Node> nodeList;

}
