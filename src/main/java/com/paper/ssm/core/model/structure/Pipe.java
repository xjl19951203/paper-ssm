package com.paper.ssm.core.model.structure;

import com.paper.ssm.core.model.Model;
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
public class Pipe extends Model implements Cloneable{


    /** 指向子级孩子坐标 */
    public static final Integer CHILD_DIRECTION = 1;
    /** 指向同级兄弟坐标 */
    public static final Integer SIBLING_DIRECTION = 2;
    /** 指向父级父亲坐标 */
    public static final Integer PARENT_DIRECTION = 3;

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
