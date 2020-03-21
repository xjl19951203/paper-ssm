package com.paper.ssm.mvc.service;

import com.paper.ssm.model.normalize.Chain;
import com.paper.ssm.model.structure.Graph;
import com.paper.ssm.model.structure.Node;
import com.paper.ssm.model.structure.Pipe;
import com.paper.ssm.model.structure.Point;
import com.paper.ssm.model.task.Bind;
import com.paper.ssm.model.task.Task;
import com.paper.ssm.mvc.dao.task.TaskDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
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
    @Resource
    ChainService chainService;

    @Override
    public Task insert(Task record) {
        this.taskDao.insert(record);
        return record;
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
        this.taskDao.update(record);
        return record;
    }

    @Override
    public Task selectSimpleByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public List<Task> selectListByQuery(Task query) {
        return this.taskDao.selectListByQuery(query);
    }

    @Override
    public Integer selectCountByQuery(Task query) {
        return null;
    }

    @Override
    public Task selectByPrimaryKey(Integer id) {
        Task task = this.taskDao.selectByPrimaryKey(id);
        if (task == null) {
            return null;
        }
        task.setNode(this.nodeService.selectByPrimaryKey(task.getNodeId()));
        HashMap<Integer, Chain> bindMap = new HashMap<>(10);
        for (Bind bind : task.getBindList()) {
            bindMap.put(bind.getNodeId(), this.chainService.selectByPrimaryKey(bind.getChainId()));
            if (bind.getNodeId().equals(task.getNodeId())) {
                task.getNode().setChain(bindMap.get(task.getNodeId()));
            }
        }
        try {
            ArrayList<Point> pointList = new ArrayList<>();
            task.getNode().setLabel("(1,1)");
            if (bindMap.containsKey(task.getNodeId())) {
                task.getNode().setChain(bindMap.get(task.getNodeId()));
            }
            Point point = new Point();
            point.setNode(task.getNode());
            point.setLabel(task.getNode().getLabel());
            point.setTitle(task.getNode().getTitle());
            point.setStyle(Point.COMPLEX_STYLE);
            point.setChain(task.getNode().getChain());
            pointList.add(point);
            buildChainTree(task.getNode(), pointList, bindMap);
            task.getNode().setPointList(pointList);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return task;
    }

    /**
     * 构造规则链
     * @param node 当前目标结点
     * @param bindMap 任务配置的结点规则链
     */
    public void buildChainTree(Node node, List<Point> pointList, HashMap<Integer, Chain> bindMap)
            throws CloneNotSupportedException {
        if (node == null) {
            return;
        }
        if (node.getPointList() != null) {
            for (Point point : node.getPointList()) {
                { /**============================ 给Point和node命名==========================*/
                    String inputLabel = node.getLabel() + "(" + point.getVertical()
                            + "," + point.getHorizontal() + ")";
                    point.setLabel(inputLabel);
                    if (point.getNode().getChildList().size() > 0) {
                        point.setStyle(Point.COMPLEX_STYLE);
                    } else {
                        point.setStyle(Point.SINGLE_STYLE);
                    }
                    point.setTitle(point.getNode().getTitle());
                }
                /**============================ 给Point和node设置规则链==========================*/
                Chain chain = null;
                /** 1. 继承来自父节点node的chain */
                if (node.getChain() != null) {
                    point.setChain(node.getChain());
                    chain = point.getChain();
                }
                /** 2. 拼接point自身关联的node的chain */
                if (bindMap.containsKey(point.getNodeId())) {
                    if (chain == null) {
                        chain = bindMap.get(point.getNodeId());
                    } else {
                        chain = chain.append(bindMap.get(point.getNodeId()));
                    }
                }
                Point point1 = (Point) point.clone();
                point1.setChain(chain);
                pointList.add(point1);
                /** 将每个坐标点的标签传递给与其关联的结点 */
                Node pointNode = (Node) point.getNode().clone();
                pointNode.setChain(chain);
                pointNode.setLabel(point.getLabel());
                buildChainTree(pointNode, pointList, bindMap);
            }
        }
    }

}
