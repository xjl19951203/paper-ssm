package com.paper.ssm.mvc.dao.structure;

import com.paper.ssm.mvc.dao.SQL;
import com.paper.ssm.model.structure.Pipe;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PipeDao extends SQL<Pipe> {
}
