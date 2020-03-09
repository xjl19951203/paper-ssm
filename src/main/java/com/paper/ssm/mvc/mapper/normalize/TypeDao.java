package com.paper.ssm.mvc.mapper.normalize;

import com.paper.ssm.model.normalize.chains.Type;
import com.paper.ssm.mvc.common.SQL;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TypeDao extends SQL<Type> {
}
