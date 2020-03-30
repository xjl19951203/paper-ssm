package com.paper.ssm.mvc.dao.instantiate;

import com.paper.ssm.model.instantiate.Instance;
import com.paper.ssm.mvc.dao.SQL;
import org.apache.ibatis.annotations.Mapper;

/**
 * @className: TaskDao
 * @author: ZengYuan
 * @description:
 * @date 2020/3/10 0:20
 * @version: 1.0
 */
@Mapper
public interface InstanceDao extends SQL<Instance> {
}
