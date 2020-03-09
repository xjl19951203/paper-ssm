package com.paper.ssm.model.normalize;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.paper.ssm.model.Model;
import com.paper.ssm.model.normalize.chains.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Rule与Element之间 1:M的关系，一条规则可以被多个Value使用，
 * 每个Value对某一类型的Rule只允许关联一条
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
