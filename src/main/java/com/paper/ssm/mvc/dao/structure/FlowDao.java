package com.paper.ssm.mvc.dao.structure;

import com.paper.ssm.model.structure.Flow;
import com.paper.ssm.mvc.dao.SQL;
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
