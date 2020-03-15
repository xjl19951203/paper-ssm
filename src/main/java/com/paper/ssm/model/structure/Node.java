package com.paper.ssm.model.structure;

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
public class Node extends Component {

    /** 最小粒度结点 */
    public static final Integer SINGLE_STYLE = 0;
    /** 复合体结点 */
    public static final Integer COMPLEX_STYLE = 1;

    /** 复合结点还是单元结点 */
    private Integer style;
    /** 返回时排除掉这个字段 */
    /** @JsonIgnore */
    private List<Pipe> childPipeList;
    private List<Pipe> parentPipeList;
    /** 返回时排除掉这个字段 */
    /** @JsonIgnore */
    private List<Pipe> nextPipeList;
    /** 从属的内左侧集合 */
    private List<Node> childList;
    /** 同级的外右侧集合 */
    private List<Node> nextList;
    /** 该chain并不一定存在于MySQL中，
     * 而是通过规则链的降维、合并、冲突等算法计算出来的
     * 赋予最小粒度结点的最终规则链
     */
    private Chain chain;
}
