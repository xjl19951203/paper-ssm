package com.paper.ssm.model.structure.node;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.paper.ssm.model.structure.line.Bridge;
import com.paper.ssm.model.structure.graph.Graph;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Multi-Level DAG
 * @author ZengYuan
 */
@Getter
@Setter
public class Cube extends Node {

    /** 返回时排除掉这个字段 */
    /** @JsonIgnore */
    private List<Bridge> innerBridgeList;
    /** 返回时排除掉这个字段 */
    /** @JsonIgnore */
    private List<Bridge> nextBridgeList;
    /** 从属的内左侧集合 */
    private List<Cube> innerCubeList;
    /** 同级的外右侧集合 */
    private List<Cube> nextCubeList;
    private Integer graphId;
    private Graph graph;
}