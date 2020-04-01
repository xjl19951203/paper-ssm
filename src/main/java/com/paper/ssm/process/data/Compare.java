package com.paper.ssm.process.data;

import com.paper.ssm.model.normalize.Attribute;
import lombok.Getter;
import lombok.Setter;

/**
 * @className: Compare
 * @author: ZengYuan
 * @description:
 * @date 2020/4/1 22:17
 * @version: 1.0
 */
@Setter
@Getter
public class Compare {

    private Integer ruleId;
    private Attribute attribute;
    private Field field;
    private Data data;

}
