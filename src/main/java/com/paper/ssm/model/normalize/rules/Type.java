package com.paper.ssm.model.normalize.rules;

import lombok.Getter;
import lombok.Setter;

/**
 * 数据类型规范
 * @author ZengYuan
 */
@Setter
@Getter
public class Type extends Rule {

    /**
     * 字符串
     */
    public static final Integer STRING_FLAG = 1;
    /**
     * 整型
     */
    public static final Integer INTEGER_FLAG = 2;
    /**
     * 浮点型
     */
    public static final Integer DOUBLE_FLAG = 3;
    /**
     * 布尔型
     */
    public static final Integer BOOLEAN_FLAG = 4;

    private Integer flag;

}
