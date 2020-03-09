package com.paper.ssm.model.normalize.chains;

/**
 * 数据类型规范
 */
public class Type extends Chain {

    public static final Integer STRING_FLAG = 1; // 字符串
    public static final Integer INTEGER_FLAG = 2; // 整型
    public static final Integer DOUBLE_FLAG = 3; // 浮点型
    public static final Integer BOOLEAN_FLAG = 4; // 布尔型

    private Integer flag;

    @Override
    public void execute() {

    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }
}
