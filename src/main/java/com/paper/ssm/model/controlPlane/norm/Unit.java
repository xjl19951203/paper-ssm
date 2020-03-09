package com.paper.ssm.model.controlPlane.norm;

import com.paper.ssm.model.controlPlane.Rule;

/**
 * 单位约束实例
 */
public abstract class Unit extends Rule {

    private Integer id;
    private String title;

    /**
     * 将入参单位，转换成本类单位
     * @param origin 待转换单位
     * @return 目标单位/本类单位
     */
    public abstract Unit transfer(Unit origin);

}
