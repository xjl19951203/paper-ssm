package com.paper.ssm.model.structure;

import com.paper.ssm.model.Model;
import lombok.Getter;
import lombok.Setter;

/**
 *  模型的元素的公共父类：
 * （1）子类：
 *  a. Node：点
 *  b. Link: 线
 *  c: Graph：面
 *
 *  a. 数据结点；Data，最小粒度、不可拆分，承载数据能力
 *  b. 管道结点；Pipe，有向的连接两个Data结点，作为数据桥梁，解决数据规范、转换等
 *  c. 图结点；Graph，基于DAG的邻接表实现，可以作为子节点构造更大的graph
 *  d. 边界结点：Edge，通过构建Graph与Data之间的联系，约束Graph的边界
 *
 *  Pipe和Edge的区别：
 *  前者是与Data一个层面，着力于打通数据结点的通道，后者与Graph一个层面只用来界定边界，不具备数据能力
 *
 * 1. DAG基于邻接表实现
 * 2. 与常规DAG不同，Graph有可能是更大的Graph的组成结点
 * 3. XML <=> DAG，二者互相转换
 * @author ZengYuan
 */
@Getter
@Setter
public class Component extends Model {

    /** dagre-d3 使用label标识 */
    protected String label;

}
