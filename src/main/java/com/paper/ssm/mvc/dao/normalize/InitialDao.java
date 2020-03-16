package com.paper.ssm.mvc.dao.normalize;

import com.paper.ssm.model.normalize.rules.Initial;
import com.paper.ssm.mvc.dao.SQL;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author ZengYuan
 */
@Mapper
public interface InitialDao extends SQL<Initial> {
}
