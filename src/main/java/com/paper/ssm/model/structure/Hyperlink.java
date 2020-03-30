package com.paper.ssm.model.structure;

import com.paper.ssm.model.Model;
import lombok.Getter;
import lombok.Setter;

/**
 * @className: Hyperlink
 * @author: ZengYuan
 * @description: 超链接
 * @date 2020/3/30 17:19
 * @version: 1.0
 */
@Getter
@Setter
public class Hyperlink extends Model  {

    private Integer pointId;
    private Integer nodeId;
    private Point point;
    private Node node;

}
