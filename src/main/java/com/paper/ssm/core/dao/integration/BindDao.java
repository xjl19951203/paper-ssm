package com.paper.ssm.core.dao.integration;

import com.paper.ssm.core.model.integration.Bind;
import com.paper.ssm.core.dao.SQL;
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
