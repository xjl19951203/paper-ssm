package com.paper.ssm.core.model.normalize;

import com.paper.ssm.core.model.Model;
import lombok.Getter;
import lombok.Setter;

/**
 * @className: AttrRef
 * @author: ZengYuan
 * @description:
 * @date 2020/4/13 8:51
 * @version: 1.0
 */
@Setter
@Getter
public class AttrRef extends Model {

    private Integer id;
    private Integer parentId;
    private Integer childId;
    private Information parent;
    private Attribute child;

}
