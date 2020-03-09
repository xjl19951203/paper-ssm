package com.paper.ssm.model.normalize.chains;

/**
 * 单位约束实例
 */
public class Unit extends Chain {

    private Integer unitId;

    @Override
    public void execute() {

    }

    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }
}
