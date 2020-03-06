package com.paper.ssm.model.dataPlane;

public class DataEdge extends Edge {

    private Integer dataId; // 边界联系的所属图内Data结点主键
    private Data data; // 边界关联内部Data结点

    public Integer getDataId() {
        return dataId;
    }

    public void setDataId(Integer dataId) {
        this.dataId = dataId;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
