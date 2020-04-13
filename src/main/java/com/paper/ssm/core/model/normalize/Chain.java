package com.paper.ssm.core.model.normalize;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.paper.ssm.core.model.Model;
import lombok.Getter;
import lombok.Setter;

/**
 * 规则链，与规则库构建关联关系
 * @author ZengYuan
 */
@Getter
@Setter
public class Chain extends Model implements Cloneable{

    private Integer id;
    private Integer leftId;
    private Integer rightId;
    private Integer attributeId;
    @JsonIgnore
    private Rule left;
    private Rule right;
    @JsonIgnore
    private Attribute attribute;

}
