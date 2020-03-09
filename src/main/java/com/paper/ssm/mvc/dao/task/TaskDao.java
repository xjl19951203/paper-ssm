package com.paper.ssm.mvc.dao.task;

import com.paper.ssm.mvc.dao.SQL;
import com.paper.ssm.model.task.Task;
import org.apache.ibatis.annotations.Mapper;

/**
 * @className: TaskDao
 * @author: ZengYuan
 * @description:
 * @date 2020/3/10 0:20
 * @version: 1.0
 */
@Mapper
public interface TaskDao extends SQL<Task> {
}
