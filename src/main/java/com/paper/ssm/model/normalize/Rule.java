package com.paper.ssm.model.normalize;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.paper.ssm.model.Model;
import com.paper.ssm.model.normalize.chains.*;

import java.util.List;

/**
 * Rule与Element之间 1:M的关系，一条规则可以被多个Value使用，每个Value对某一类型的Rule只允许关联一条
 */
public abstract class Rule extends Model {

    /**
     * 关联的规则
     */
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

    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    public Integer getRangeId() {
        return rangeId;
    }

    public void setRangeId(Integer rangeId) {
        this.rangeId = rangeId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getDefaultId() {
        return defaultId;
    }

    public void setDefaultId(Integer defaultId) {
        this.defaultId = defaultId;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public Range getRange() {
        return range;
    }

    public void setRange(Range range) {
        this.range = range;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Default getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(Default defaultValue) {
        this.defaultValue = defaultValue;
    }

    public List<Chain> getChainList() {
        return chainList;
    }

    public void setChainList(List<Chain> chainList) {
        this.chainList = chainList;
    }

    /**
     * 该“执行方法”在结点实例在实现规范化处理时，会被调用
     * 所有规范化子类，都需要实现这个方法
     */
    public abstract void execute();
}
