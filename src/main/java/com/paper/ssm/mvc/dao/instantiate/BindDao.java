package com.paper.ssm.mvc.dao.instantiate;

import com.paper.ssm.model.instantiate.Bind;
import com.paper.ssm.mvc.dao.SQL;
import org.apache.ibatis.annotations.Mapper;

/**
 * @className: BindDao
 * @author: ZengYuan
 * @description:
 * @date 2020/3/10 0:27
 * @version: 1.0
 */
@Mapper
public interface BindDao extends SQL<Bind> {
}
