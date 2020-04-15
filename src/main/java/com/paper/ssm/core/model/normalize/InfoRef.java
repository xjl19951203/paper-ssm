package com.paper.ssm.core.model.normalize;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.paper.ssm.core.model.Model;
import lombok.Getter;
import lombok.Setter;

/**
 * @className: Link
 * @author: ZengYuan
 * @description: 规则链的组成要素，
 * 构建规则链与规则实例的联系，具有逻辑计算以及规则实例排序的功能
 * @date 2020/3/16 17:05
 * @version: 1.0
 */
@Setter
@Getter
public class InfoRef extends Model {

    private Integer id;
    private Integer parentId;
    private Integer childId;
    private Information parent;
    private Information child;

}
