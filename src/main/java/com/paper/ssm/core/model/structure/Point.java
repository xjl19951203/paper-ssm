package com.paper.ssm.core.model.structure;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.paper.ssm.core.model.Model;
import com.paper.ssm.core.model.normalize.Chain;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @className: Point
 * @author: ZengYuan
 * @description: 加入point这个中间层：point和pipe对于node有归属，
 *               node自身没有归属，所以能实现node的解耦与复用
 * @date 2020/3/18 19:35
 * @version: 1.0
 */
@Getter
@Setter
public class Point extends Model implements Cloneable{

    /** 最小粒度结点 */
    public static final Integer SINGLE_STYLE = 0;
    /** 复合体结点 */
    public static final Integer COMPLEX_STYLE = 1;

    /**
     * 通过point(x, y)二元组实现node的一级子节点内容的二维平面组织关系
     * 通过point(namespace, vertical, horizontal)三元组确定模型在多层级三维空间中的结构组织关系
     */
    private Integer x;
    private Integer y;
    /** 复合坐标还是数据坐标，由其超链接关联的结点类型决定 */
    private Integer style;
    /** 该坐标点所属的结点模型*/
    private Integer parentId;
    @JsonIgnore
    private Hyperlink hyperlink;
    /** hyperlink指向的node */
    @JsonIgnore
    private Node node;
    @JsonIgnore
    private List<Pipe> inputList;
    @JsonIgnore
    private List<Pipe> outputList;
    /** 1.从关联的Node承接过来，2.从上层继承下来 */
    private Chain chain;

    @Override
    public Object clone() throws CloneNotSupportedException {
        Point point = (Point) super.clone();
//        Node node = (Node) point.getNode().clone();
//        point.setNode(node);
        return point;
    }
}
