package com.paper.ssm.mapper;

import com.paper.ssm.common.SQL;
import com.paper.ssm.model.dataPlane.Bridge;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BridgeDao extends SQL<Bridge> {
}