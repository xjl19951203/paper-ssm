package com.paper.ssm.core.model.normalize;

import com.paper.ssm.core.model.Model;
import lombok.Getter;
import lombok.Setter;

/**
 * @className: RuleMeta
 * @author: ZengYuan
 * @description: 规则元
 * @date 2020/4/12 23:34
 * @version: 1.0
 */
@Setter
@Getter
public class Metadata extends Model {

    private Integer id;
    private String title;
    private String value;

}
