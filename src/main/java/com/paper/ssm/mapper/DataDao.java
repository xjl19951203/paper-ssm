package com.paper.ssm.mapper;

import com.paper.ssm.common.SQL;
import com.paper.ssm.model.dataPlane.Data;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DataDao extends SQL<Data> {
}
