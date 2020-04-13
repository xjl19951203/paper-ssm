package com.paper.ssm.core.model.normalize;

import lombok.Getter;
import lombok.Setter;

/**
 * @className: RuleMacro
 * @author: ZengYuan
 * @description: 规则模型与主键的宏定义
 * @date 2020/4/1 20:38
 * @version: 1.0
 */
@Getter
@Setter
public class RuleMacro {

    public final static int DEFAULT = 1;
    public final static int LESS = 2;
    public final static int LESS_AND_EQUAL = 3;
    public final static int MORE = 4;
    public final static int MORE_AND_EQUAL = 5;
    public final static int UNIT = 6;
    public final static int DATATYPE = 7;

}
