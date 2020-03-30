package com.paper.ssm.model.normalize;

import com.paper.ssm.model.Model;
import lombok.Getter;
import lombok.Setter;

/**
 * @className: Link
 * @author: ZengYuan
 * @description:
 * @date 2020/3/16 17:05
 * @version: 1.0
 */
@Setter
@Getter
public class Link extends Model {

    private Integer chainId;
    private Integer baseId;
    private Chain chain;
    private Attribute attribute;
}
