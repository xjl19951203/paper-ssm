package com.paper.ssm.model.normalize.chains;

/**
 * 取值范围约束实例
 */
public class Range extends Chain {

    public static final Integer LESS_FLAG = 1;  // 小于min
    public static final Integer LESS_EQUAL_FLAG = 2; //小于或等于min
    public static final Integer BETWEEN_FLAG = 3; // 大于min，小于max
    public static final Integer BETWEEN_MIN_EQUAL_FLAG = 4; // 大于或等于min，小于max
    public static final Integer BETWEEN_MAX_EQUAL_FLAG = 5; // 大于min，小于或等于max
    public static final Integer BETWEEN_BOTH_EQUAL_FLAG = 6; // 大于或等于min，小于或等于max
    public static final Integer GREATER_EQUAL_FLAG = 7; // 大于或等于max
    public static final Integer GREATER_FLAG = 8; // 大于max

    private String max;
    private String min;
    private Integer flag;

    @Override
    public void execute() {

    }

    public String getMax() {
        return max;
    }

    public void setMax(String max) {
        this.max = max;
    }

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }
}
