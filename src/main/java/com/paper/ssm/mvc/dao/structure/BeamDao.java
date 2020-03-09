package com.paper.ssm.mvc.dao.structure;

import com.paper.ssm.mvc.dao.SQL;
import com.paper.ssm.model.structure.line.Beam;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BeamDao extends SQL<Beam> {
}
