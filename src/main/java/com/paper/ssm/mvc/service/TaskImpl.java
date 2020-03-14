package com.paper.ssm.mvc.service;

import com.paper.ssm.model.structure.Node;
import com.paper.ssm.model.task.Bind;
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
//        makeChain(task, task.getNode());
        return task;
    }

    @Override
    public Task selectSimpleByPrimaryKey(Integer id) {
        return null;
    }

    /**
     * 构造规则链
     * @param task 目标任务
     * @param node 当前目标结点
     * @return 当前已附加规则链的目标结点
     */
    private Node makeChain(Task task, Node node) {
        if (node == null) {
            return null;
        }
        Bind bind = getBind(task, node.getId());
        if (bind != null) {
            node.setChain(bind.getChain());
        }
        return null;
    }

    /**
     * 按nodeId,找出task实例的bing集合中的对应bind实例
     * @param task 目标task实例
     * @param nodeId 目标nodeId
     * @return 目标 Bind实例
     */
    private Bind getBind(Task task, Integer nodeId) {
        if (task.getBindList() == null || task.getBindList().size() == 0) {
            return null;
        }
        for (Bind bind : task.getBindList()) {
            if (bind.getNodeId().equals(nodeId)) {
                return bind;
            }
        }
        return null;
    }
}
