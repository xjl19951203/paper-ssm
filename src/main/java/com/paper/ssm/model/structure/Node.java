package com.paper.ssm.model.structure;

import com.paper.ssm.model.normalize.Chain;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 结点型元素
 *
 * 子类：
 * a. Data
 * b. Cube
 * @author ZengYuan
 */
@Getter
@Setter
public class Node extends Component {

    /** 最小粒度结点 */
    public static final Integer SINGLE_TYPE = 0;
    /** 复合体结点 */
    public static final Integer COMPLEX_TYPE = 1;

    /** 复合结点还是单元结点 */
    private Integer type;
    /** 返回时排除掉这个字段 */
    /** @JsonIgnore */
    private List<Pipe> innerPipeList;
    /** 返回时排除掉这个字段 */
    /** @JsonIgnore */
    private List<Pipe> nextPipeList;
    /** 从属的内左侧集合 */
    private List<Node> innerNodeList;
    /** 同级的外右侧集合 */
    private List<Node> nextNodeList;
    /** 该chain并不一定存在于MySQL中，
     * 而是通过规则链的降维、合并、冲突等算法计算出来的
     * 赋予最小粒度结点的最终规则链
     */
    private Chain chain;
}
