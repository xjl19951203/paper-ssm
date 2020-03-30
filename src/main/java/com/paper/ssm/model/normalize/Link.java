package com.paper.ssm.model.normalize;

import com.paper.ssm.model.Model;
import lombok.Getter;
import lombok.Setter;

/**
 * @className: Link
 * @author: ZengYuan
 * @description: 规则链的组成要素，
 * 构建规则链与规则实例的联系，具有逻辑计算以及规则实例排序的功能
 * @date 2020/3/16 17:05
 * @version: 1.0
 */
@Setter
@Getter
public class Link extends Model {

    private Integer chainId;
    private Integer attributeId;
    private Chain chain;
    private Attribute attribute;
}
