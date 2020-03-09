package com.paper.ssm.mvc.mapper.structure;

import com.paper.ssm.mvc.common.SQL;
import com.paper.ssm.model.structure.node.Cube;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CubeDao extends SQL<Cube> {
}
