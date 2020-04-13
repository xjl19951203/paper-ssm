package com.paper.ssm.core.dao.integration;

import com.paper.ssm.core.model.integration.Process;
import com.paper.ssm.core.dao.SQL;
import org.apache.ibatis.annotations.Mapper;

/**
 * @className: TaskDao
 * @author: ZengYuan
 * @description:
 * @date 2020/3/10 0:20
 * @version: 1.0
 */
@Mapper
public interface ProcessDao extends SQL<Process> {
}
