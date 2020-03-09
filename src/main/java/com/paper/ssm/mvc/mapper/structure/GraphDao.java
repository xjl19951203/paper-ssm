package com.paper.ssm.mvc.mapper.structure;

import com.paper.ssm.mvc.common.SQL;
import com.paper.ssm.model.structure.graph.Graph;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GraphDao extends SQL<Graph> {
}
