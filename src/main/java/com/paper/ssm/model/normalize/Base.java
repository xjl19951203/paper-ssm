package com.paper.ssm.model.normalize;

import com.paper.ssm.model.Model;
import lombok.Getter;
import lombok.Setter;

/**
 * @className: Base
 * @author: ZengYuan
 * @description: 规则库
 * @date 2020/3/20 13:41
 * @version: 1.0
 */
@Getter
@Setter
public class Base extends Model {

    private Integer ruleId;
    private String value;
    private Rule rule;

}
