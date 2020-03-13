package com.paper.ssm.mvc.service;

import com.paper.ssm.model.task.Task;
import com.paper.ssm.mvc.dao.task.TaskDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @className: TaskImpl
 * @author: ZengYuan
 * @description:
 * @date 2020/3/10 0:50
 * @version: 1.0
 */
@Service("taskService")
public class TaskImpl implements TaskService {

    @Resource
    TaskDao taskDao;
    @Resource
    NodeService nodeService;

    @Override
    public Task insert(Task record) {
        return null;
    }

    @Override
    public int insert(List<Task> records) {
        return 0;
    }

    @Override
    public int delete(Task record) {
        return 0;
    }

    @Override
    public Task update(Task record) {
        return null;
    }

    @Override
    public List<Task> selectListByQuery(Task query) {
        return null;
    }

    @Override
    public Integer selectCountByQuery(Task query) {
        return null;
    }

    @Override
    public Task selectByPrimaryKey(Integer id) {
        Task task = this.taskDao.selectByPrimaryKey(id);
        if (task.getNodeId() != null) {
            task.setNode(this.nodeService.selectByPrimaryKey(task.getNodeId()));
        }
        return task;
    }

    @Override
    public Task selectSimpleByPrimaryKey(Integer id) {
        return null;
    }
}
