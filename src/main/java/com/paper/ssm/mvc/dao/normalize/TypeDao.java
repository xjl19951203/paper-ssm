package com.paper.ssm.mvc.dao.normalize;

import com.paper.ssm.model.normalize.rules.Type;
import com.paper.ssm.mvc.dao.SQL;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TypeDao extends SQL<Type> {
}
