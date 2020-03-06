package com.paper.ssm.model.controlPlane.norm;

/**
 * 单位规范
 */
public abstract class UnitNorm extends Norm {

    /**
     * 将入参单位，转换成本类单位
     * @param origin 待转换单位
     * @return 目标单位/本类单位
     */
    public abstract UnitNorm transfer(UnitNorm origin);

}
