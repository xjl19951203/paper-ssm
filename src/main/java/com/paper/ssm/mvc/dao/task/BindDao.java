package com.paper.ssm.mvc.dao.task;

import com.paper.ssm.model.structure.Node;
import com.paper.ssm.model.task.Bind;
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
