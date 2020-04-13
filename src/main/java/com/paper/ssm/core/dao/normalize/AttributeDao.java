package com.paper.ssm.core.dao.normalize;

import com.paper.ssm.core.model.normalize.Attribute;
import com.paper.ssm.core.dao.SQL;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author ZengYuan
 */
@Mapper
public interface AttributeDao extends SQL<Attribute> {
}
