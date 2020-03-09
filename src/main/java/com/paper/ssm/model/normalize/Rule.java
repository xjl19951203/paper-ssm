package com.paper.ssm.model.normalize;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.paper.ssm.model.Model;
import com.paper.ssm.model.normalize.chains.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Rule与 Node 之间 M:N的关系，即某个结点Node的规则链，是与相关的Rule集合的Chain的并集
 * 并且该每一种类型的Chain只能存在一个，这里涉及要优先级的问题
 * @author ZengYuan
 */
@Setter
@Getter
public class Rule extends Model {

    @JsonIgnore
    private Integer unitId;
    @JsonIgnore
    private Integer rangeId;
    @JsonIgnore
    private Integer typeId;
    @JsonIgnore
    private Integer defaultId;
    @JsonIgnore
    private Unit unit;
    @JsonIgnore
    private Range range;
    @JsonIgnore
    private Type type;
    @JsonIgnore
    private Default defaultValue;
    /**
     * chainList 是经由上面四类Chain合成的，可以传递给Pipe进行规则链计算
     */
    private List<Chain> chainList;
}
