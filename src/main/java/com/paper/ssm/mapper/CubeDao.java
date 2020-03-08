package com.paper.ssm.mapper;

import com.paper.ssm.common.SQL;
import com.paper.ssm.model.dataPlane.Cube;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CubeDao extends SQL<Cube> {
}
