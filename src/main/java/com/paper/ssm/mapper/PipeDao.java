package com.paper.ssm.mapper;

import com.paper.ssm.common.SQL;
import com.paper.ssm.model.dataPlane.Pipe;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PipeDao extends SQL<Pipe> {
}
