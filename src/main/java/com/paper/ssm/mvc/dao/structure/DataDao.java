package com.paper.ssm.mvc.dao.structure;

import com.paper.ssm.mvc.dao.SQL;
import com.paper.ssm.model.task.Data;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DataDao extends SQL<Data> {
}
