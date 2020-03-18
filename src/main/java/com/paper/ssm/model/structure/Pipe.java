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
public class Pipe extends Component implements Cloneable{

    /** 复合结点的pipe：虚线 */
    public static final Integer COMPLEX_STYLE = 0;
    /** 不可再分结点的pipe：实线 */
    public static final Integer SINGLE_STYLE = 1;

    /** 管道的显示样式 */
    private Integer style;
    private Integer direction;
    private Integer inputId;
    private Integer outputId;
    private String inputLabel;
    private String outputLabel;
    private Point input;
    private Point output;
    /** 两个结点之间的管道存在：零条、一条、或多条数据流，*/
    private List<Flow> flowList;

    @Override
    public String toString() {
        return "Pipe{" +
                "style=" + style +
                ", inputId=" + inputId +
                ", outputId=" + outputId +
                ", input=" + input +
                ", output=" + output +
                '}';
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
