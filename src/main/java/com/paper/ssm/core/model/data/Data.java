package com.paper.ssm.core.model.data;

import com.paper.ssm.core.model.normalize.Attribute;
import org.influxdb.annotation.Column;
import org.influxdb.annotation.Measurement;

import java.util.List;

/**
 * Data是不可再细分的数据结点，属于最小粒度的结点类型
 *
 * 在模型层面上支持多条Edge的输入和多条edge的输出
 *
 * 注意Data作为一个独立个体，
 * 它自身不关注输入是从哪些结点来，将会输送到哪些结点
 * 其输入和输出的关系，是交由edge来构成并维护结点间的联系，
 * 因此基于edge作为中介，Data之间是M:N的范式
 * 它更专注于自身的规范化，而与之输入输出相关联的edge则基于它的规范化实现数据转换
 *
 * 另外一方面：输入具体指的是输入了什么东西，有什么用？
 * data又输出了什么？和输入有什么关系？
 *
 * @className: Value
 * @author: ZengYuan
 * @description:
 * @date 2020/3/10 10:35
 * @version: 1.0
 */
@Measurement(name = "data")
@lombok.Data
public class Data extends Query{

    private static final long serialVersionUID = 1L;

    private String time;

    @Column(name = "processId")
    private Integer processId;

    @Column(name = "pointId")
    private Integer pointId;

    @Column(name = "attributeId")
    private Integer attributeId;

    /** 具体的值 */
    @Column(name = "value")
    private String value;

}
