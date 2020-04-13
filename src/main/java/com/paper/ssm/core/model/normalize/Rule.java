package com.paper.ssm.core.model.normalize;

import com.paper.ssm.core.model.Model;
import lombok.Getter;
import lombok.Setter;

/**
 * 规则三元组模型
 * @author ZengYuan
 */
@Setter
@Getter
public class Rule extends Model {

    private Integer id;
    private String title;
    private Integer metadataId;
    private Metadata metadata;

}
