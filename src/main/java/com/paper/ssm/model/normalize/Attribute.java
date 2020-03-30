package com.paper.ssm.model.normalize;

import com.paper.ssm.model.Model;
import lombok.Getter;
import lombok.Setter;

/**
 * @className: Attribute
 * @author: ZengYuan
 * @description: 规则实例库
 * @date 2020/3/20 13:41
 * @version: 1.0
 */
@Getter
@Setter
public class Attribute extends Model {

    private Integer ruleId;
    private String value;
    private Rule rule;

}
