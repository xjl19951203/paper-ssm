package com.paper.ssm.core.model.structure;

import com.paper.ssm.core.model.Model;
import lombok.Getter;
import lombok.Setter;

/**
 * @className: Flow
 * @author: ZengYuan
 * @description: 数据流，只存在于两个数据结点之间，单向的
 * @date 2020/3/17 21:30
 * @version: 1.0
 */
@Setter
@Getter
public class Flow extends Model {

    private String label;
    /** 该数据流属于哪个管道 */
    private Integer pipeId;
    private Pipe pipe;
    /** 该数据流的输入和输出数据结点 */
    private Integer inputId;
    private Integer outputId;
    private Node input;
    private Node output;

}
