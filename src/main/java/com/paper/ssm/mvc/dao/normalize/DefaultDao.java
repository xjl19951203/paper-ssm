package com.paper.ssm.mvc.dao.normalize;

import com.paper.ssm.model.normalize.rules.Default;
import com.paper.ssm.mvc.dao.SQL;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author ZengYuan
 */
@Mapper
public interface DefaultDao extends SQL<Default> {
}
