package com.paper.ssm.model.structure.node;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.paper.ssm.model.structure.line.Edge;
import com.paper.ssm.model.structure.line.Pipe;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Data是不可再细分的数据结点，属于最小粒度的结点类型
 *
 * 在模型层面上支持多条Edge的输入和多条edge的输出
 *
 * 注意Data作为一个独立个体，
 * 它自身不关注输入是从哪些结点来，将会输送到哪些结点
 * 其输入和输出的关系，是交由edge来构成并维护结点间的联系，
 * 因此基于edge作为中介，Data之间是M:N的范式
 * 它更专注于自身的规范化，而与之输入输出相关联的edge则基于它的规范化实现数据转换
 *
 * 另外一方面：输入具体指的是输入了什么东西，有什么用？
 * data又输出了什么？和输入有什么关系？
 *
 * @author ZengYuan
 */
@Getter
@Setter
public class Data extends Node {

    @JsonIgnore
    /** 内右侧的边，取side标志作递归终止条件 */
    private List<Edge> innerEdgeList;
    @JsonIgnore
    private List<Pipe> nextPipeList;
    private List<Data> nextDataList;
    // value经过input计算之后的结果，作为output的数据值

}
