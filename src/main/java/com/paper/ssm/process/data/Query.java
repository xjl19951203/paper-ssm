package com.paper.ssm.process.data;

import lombok.Getter;
import lombok.Setter;

/**
 * @className: Query
 * @author: ZengYuan
 * @description:
 * @date 2020/3/22 16:44
 * @version: 1.0
 */
@Setter
@Getter
public class Query {

    private Integer pageSize;
    private Integer pageNum;
    private Integer pointId;
    private Integer taskId;
    private String measurement;
}
