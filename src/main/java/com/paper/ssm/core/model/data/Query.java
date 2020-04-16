package com.paper.ssm.core.model.data;

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

    protected Integer pageSize;
    protected Integer pageNum;
    protected String measurement;
}
