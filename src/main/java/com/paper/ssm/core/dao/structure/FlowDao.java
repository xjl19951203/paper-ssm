package com.paper.ssm.core.dao.structure;

import com.paper.ssm.core.model.structure.Flow;
import com.paper.ssm.core.dao.SQL;
import org.apache.ibatis.annotations.Mapper;

/**
 * @className: FlowDao
 * @author: ZengYuan
 * @description:
 * @date 2020/3/17 21:58
 * @version: 1.0
 */
@Mapper
public interface FlowDao extends SQL<Flow> {
}
