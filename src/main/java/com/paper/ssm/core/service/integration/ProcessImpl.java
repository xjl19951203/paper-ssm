package com.paper.ssm.core.service.integration;

import com.google.common.graph.Graphs;
import com.paper.ssm.core.model.integration.Graph;
import com.paper.ssm.core.model.integration.Process;
import com.paper.ssm.core.model.normalize.Chain;
import com.paper.ssm.core.model.structure.Node;
import com.paper.ssm.core.model.structure.Point;
import com.paper.ssm.core.model.integration.Bind;
import com.paper.ssm.core.dao.integration.ProcessDao;
import com.paper.ssm.core.service.normalize.ChainService;
import com.paper.ssm.core.service.structure.NodeService;
import com.paper.ssm.run.graph.GraphService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @className: InstanceImpl
 * @author: ZengYuan
 * @description:
 * @date 2020/3/10 0:50
 * @version: 1.0
 */
@Service("processService")
public class ProcessImpl implements ProcessService {

    @Resource
    ProcessDao processDao;
    @Resource
    NodeService nodeService;
    @Resource
    GraphService graphService;

    @Override
    public Process insert(Process record) {
        this.processDao.insert(record);
        return record;
    }

    @Override
    public int insert(List<Process> records) {
        return 0;
    }

    @Override
    public int delete(Process record) {
        return 0;
    }

    @Override
    public Process update(Process record) {
        this.processDao.update(record);
        return record;
    }

    @Override
    public Process selectSimpleByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public List<Process> selectListByQuery(Process query) {
        return this.processDao.selectListByQuery(query);
    }

    @Override
    public Integer selectCountByQuery(Process query) {
        return null;
    }

    @Override
    public Process selectByPrimaryKey(Integer id) {
        Process process = this.processDao.selectByPrimaryKey(id);
        if (process == null) {
            return null;
        }
        process.setNode(this.nodeService.selectByPrimaryKey(process.getNodeId()));
        HashMap<Integer, Chain> bindMap = new HashMap<>(10);
        for (Bind bind : process.getBindList()) {
//            bindMap.put(bind.getNodeId(), this.chainService.selectByPrimaryKey(bind.getInformation()));
            if (bind.getNodeId().equals(process.getNodeId())) {
                process.getNode().setChain(bindMap.get(process.getNodeId()));
            }
        }
        try {
            ArrayList<Point> pointList = new ArrayList<>();
            process.getNode().setLabel("(1,1)");
            if (bindMap.containsKey(process.getNodeId())) {
                process.getNode().setChain(bindMap.get(process.getNodeId()));
            }
            Point point = new Point();
            point.setNode(process.getNode());
            point.setId(process.getNode().getId());
            point.setLabel(process.getNode().getLabel());
            point.setTitle(process.getNode().getTitle());
            point.setStyle(Point.COMPLEX_STYLE);
            point.setChain(process.getNode().getChain());
            pointList.add(point);
            buildChainTree(process.getNode(), pointList, bindMap);
            process.getNode().setPointList(pointList);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return process;
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
                    String inputLabel = node.getLabel() + "(" + point.getX()
                            + "," + point.getY() + ")";
                    point.setLabel(inputLabel);
                    if (point.getHyperlink().getNode().getLeftPointList().size() > 0) {
                        point.setStyle(Point.COMPLEX_STYLE);
                    } else {
                        point.setStyle(Point.SINGLE_STYLE);
                    }
                    point.setTitle(point.getHyperlink().getNode().getTitle());
                }
                /**============================ 给Point和node设置规则链==========================*/
                Chain chain = null;
                /** 1. 继承来自父节点node的chain */
                if (node.getChain() != null) {
                    point.setChain(node.getChain());
                    chain = point.getChain();
                }
                /** 2. 拼接point自身关联的node的chain */
                if (bindMap.containsKey(point.getHyperlink().getNodeId())) {
                    if (chain == null) {
                        chain = bindMap.get(point.getHyperlink().getNodeId());
                    } else {
//                        chain = chain.append(bindMap.get(point.getHyperlink().getNodeId()));
                    }
                }
                Point point1 = (Point) point.clone();
                point1.setChain(chain);
                pointList.add(point1);
                /** 将每个坐标点的标签传递给与其关联的结点 */
                Node pointNode = (Node) point.getHyperlink().getNode().clone();
                pointNode.setChain(chain);
                pointNode.setLabel(point.getLabel());
                buildChainTree(pointNode, pointList, bindMap);
            }
        }
    }

    @Override
    public Graph get(Integer id) {
        Process process = this.processDao.selectByPrimaryKey(id);

        Graph graph = this.graphService.get(process.getNodeId());
        for (Point point : graph.getPointList()) {
            for (Bind bind : process.getBindList()) {
                if (point.getNodeId() != null && point.getNodeId().equals(bind.getNodeId())) {
                    point.setInformation(bind.getInformation());
                }
            }
        }
        return graph;
    }
}
