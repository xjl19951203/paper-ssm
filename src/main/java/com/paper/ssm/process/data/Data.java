package com.paper.ssm.process.data;

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
public class Data {

    private static final long serialVersionUID = 1L;

    /** 一个Point实例对应一组Value数据实例，是1：M的关系 */
    @Column(name = "pointId")
    private Integer pointId;

    /** Data是属于某个采集实例的 */
    @Column(name = "instanceId")
    private Integer instanceId;

    /** 具体的值 */
    @Column(name = "value")
    private String value;

    /** 规范化后的规则实例/属性集合 */
    private List<Field> fieldList;

}
