package com.paper.ssm.mvc.dao.normalize;

import com.paper.ssm.model.normalize.Base;
import com.paper.ssm.mvc.dao.SQL;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author ZengYuan
 */
@Mapper
public interface BaseDao extends SQL<Base> {
}
