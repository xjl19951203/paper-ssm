package com.paper.ssm.model.controlPlane;

import com.paper.ssm.model.controlPlane.norm.Default;
import com.paper.ssm.model.controlPlane.norm.Range;
import com.paper.ssm.model.controlPlane.norm.Type;
import com.paper.ssm.model.controlPlane.norm.Unit;

public class Value {

    // 字符串形式的值：支持Integer、Double、Boolean等类型的转换
    private String value;
    // 关联的规则
    private Integer unitId;
    private Integer rangeId;
    private Integer typeId;
    private Integer defaultId;
    private Unit unit;
    private Range range;
    private Type type;
    private Default defaultValue;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

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

}
