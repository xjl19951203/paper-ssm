package com.paper.ssm.mvc.dao.structure;

import com.paper.ssm.mvc.dao.SQL;
import com.paper.ssm.model.structure.line.Edge;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EdgeDao extends SQL<Edge> {
}
