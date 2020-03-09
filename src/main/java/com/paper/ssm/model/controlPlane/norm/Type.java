package com.paper.ssm.model.controlPlane.norm;

import com.paper.ssm.model.controlPlane.Rule;

/**
 * 数据类型规范
 */
public abstract class Type extends Rule {

    public static final Integer STRING_FLAG = 1; // 字符串
    public static final Integer INTEGER_FLAG = 2; // 整型
    public static final Integer DOUBLE_FLAG = 3; // 浮点型
    public static final Integer BOOLEAN_FLAG = 4; // 布尔型

    private Integer flag;

}
