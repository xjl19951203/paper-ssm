package com.paper.ssm.model.normalize.rules;

import com.paper.ssm.model.normalize.Rule;
import lombok.Getter;
import lombok.Setter;

/**
 * 取值范围约束实例
 * @author ZengYuan
 */
@Getter
@Setter
public class Range extends Rule {

    /**
     * 小于min
     */
    public static final Integer LESS_FLAG = 1;
    /**
     * 小于或等于min
     */
    public static final Integer LESS_EQUAL_FLAG = 2;
    /**
     * 大于min，小于max
     */
    public static final Integer BETWEEN_FLAG = 3;
    /**
     * 大于或等于min，小于max
     */
    public static final Integer BETWEEN_MIN_EQUAL_FLAG = 4;
    /**
     * 大于min，小于或等于max
     */
    public static final Integer BETWEEN_MAX_EQUAL_FLAG = 5;
    /**
     * 大于或等于min，小于或等于max
     */
    public static final Integer BETWEEN_BOTH_EQUAL_FLAG = 6;
    /**
     * 大于或等于max
     */
    public static final Integer GREATER_EQUAL_FLAG = 7;
    /**
     * 大于max
     */
    public static final Integer GREATER_FLAG = 8;

    private String max;
    private String min;
    private Integer flag;

}
