package com.paper.ssm.model.structure;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.paper.ssm.model.normalize.Chain;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 结点型元素
 * Node 与 Chain 的绑定关系不是永久不变的，
 * 只在某个具体的Task，才存在两者的关联关系
 *
 * @author ZengYuan
 */
@Getter
@Setter
public class Node extends Component implements Cloneable{

    /** 最小粒度结点 */
    public static final Integer SINGLE_STYLE = 0;
    /** 复合体结点 */
    public static final Integer COMPLEX_STYLE = 1;

    /** 采用结点空间策略，保障相同或不同的结点在数据流图空间中都有唯一的结点名称，
     * 使得同一个结点能在不同层级，同一层级的不同位置出现多次
     * 该属性不是数据表字段，而是在多叉树算法组织结点关系时由程序计算填充的
     * 由多叉树递归算法，按层级深度和宽度计算 */
    private String namespace;
    private List<Point> pointList;
    private List<Point> childList;

    /** 该chain并不一定存在于MySQL中，
     * 而是通过规则链的降维、合并、冲突等算法计算出来的
     * 赋予最小粒度结点的最终规则链
     */
    private Chain chain;

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
