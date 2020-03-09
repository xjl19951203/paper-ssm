package com.paper.ssm.mvc.mapper.structure;

import com.paper.ssm.mvc.common.SQL;
import com.paper.ssm.model.structure.Line.Beam;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BeamDao extends SQL<Beam> {
}
