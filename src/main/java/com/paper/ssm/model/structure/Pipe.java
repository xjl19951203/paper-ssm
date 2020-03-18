package com.paper.ssm.model.structure;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 边结点，连接两个简单的Data结点
 * 1. left和right数据是
 * @author ZengYuan
 */
@Getter
@Setter
public class Pipe extends Component {

    /** 复合结点的pipe：虚线 */
    public static final Integer COMPLEX_STYLE = 0;
    /** 不可再分结点的pipe：实线 */
    public static final Integer SINGLE_STYLE = 1;
    /** 左内侧边界结点的pipe：粗线 */
    public static final Integer EDGE_STYLE = 2;
    /** 指向同层级结点的管道 */
    public static final int NEXT_DIRECTION = 1;
    /** 指向子层级结点的管道 */
    public static final int CHILD_DIRECTION = 2;
    /** 指向父层级结点的管道 */
    public static final int PARENT_DIRECTION = 3;

    /** 管道的显示样式 */
    private Integer style;
    /** 管道的指向方向：指向子节点、指向同级结点、指向父节点 */
    private Integer direction;
    private Integer inputId;
    private Integer outputId;
    private Node input;
    private Node output;
    /** 保证结点复用时，仍具备辨识性 */
    private String inputName;
    private String outputName;
    /** 所属多叉树的根结点ID */
    private Integer nodeId;
    /** 两个结点之间的管道存在：零条、一条、或多条数据流，*/
    private List<Flow> flowList;

    @Override
    public String toString() {
        return "Pipe{" +
                "style=" + style +
                ", direction=" + direction +
                ", inputId=" + inputId +
                ", outputId=" + outputId +
                ", input=" + input +
                ", output=" + output +
                '}';
    }
}
