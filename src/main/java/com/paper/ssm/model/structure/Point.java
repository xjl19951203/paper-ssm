package com.paper.ssm.model.structure;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.paper.ssm.model.Model;
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
     * 通过point(vertical, horizontal)二元组实现node的一级子节点内容的二维平面组织关系
     * 通过point(namespace, vertical, horizontal)三元组确定模型在多层级三维空间中的结构组织关系
     */
    private Integer vertical;
    private Integer horizontal;
    private String label;
    private Integer style;
    /** 该坐标点所属的结点模型*/
    private Integer parentId;
    private Node parent;
    /** 该坐标点关联的结点模型 */
    private Integer nodeId;
    @JsonIgnore
    private Node node;
    @JsonIgnore
    private List<Pipe> inputList;
    @JsonIgnore
    private List<Pipe> outputList;

    @Override
    public Object clone() throws CloneNotSupportedException {
        Point point = (Point) super.clone();
//        Node node = (Node) point.getNode().clone();
//        point.setNode(node);
        return point;
    }
}
