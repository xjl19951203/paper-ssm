package com.paper.ssm.model.structure.Line;

/**
 * 构建 Graph 与 Cube之间的映射关系
 *
 * 对于最小粒度的Cube（Cube多叉树的叶子结点），一定会存在与之对应的Graph实体
 *
 * 对于非最小粒度的Cube，其对应的Graph是通过算法构造的，在MySQL中没有具体的实例与之对应
 */
public class Beam extends Line {

    private Integer cubeId;
    private Integer graphId;

    public Integer getCubeId() {
        return cubeId;
    }

    public void setCubeId(Integer cubeId) {
        this.cubeId = cubeId;
    }

    public Integer getGraphId() {
        return graphId;
    }

    public void setGraphId(Integer graphId) {
        this.graphId = graphId;
    }
}
