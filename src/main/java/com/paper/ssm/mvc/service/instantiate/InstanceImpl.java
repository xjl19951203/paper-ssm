package com.paper.ssm.mvc.service.instantiate;

import com.paper.ssm.model.instantiate.Instance;
import com.paper.ssm.model.normalize.Chain;
import com.paper.ssm.model.structure.Node;
import com.paper.ssm.model.structure.Point;
import com.paper.ssm.model.instantiate.Bind;
import com.paper.ssm.mvc.dao.instantiate.InstanceDao;
import com.paper.ssm.mvc.service.normalize.ChainService;
import com.paper.ssm.mvc.service.structure.NodeService;
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
@Service("instanceService")
public class InstanceImpl implements InstanceService {

    @Resource
    InstanceDao instanceDao;
    @Resource
    NodeService nodeService;
    @Resource
    ChainService chainService;

    @Override
    public Instance insert(Instance record) {
        this.instanceDao.insert(record);
        return record;
    }

    @Override
    public int insert(List<Instance> records) {
        return 0;
    }

    @Override
    public int delete(Instance record) {
        return 0;
    }

    @Override
    public Instance update(Instance record) {
        this.instanceDao.update(record);
        return record;
    }

    @Override
    public Instance selectSimpleByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public List<Instance> selectListByQuery(Instance query) {
        return this.instanceDao.selectListByQuery(query);
    }

    @Override
    public Integer selectCountByQuery(Instance query) {
        return null;
    }

    @Override
    public Instance selectByPrimaryKey(Integer id) {
        Instance instance = this.instanceDao.selectByPrimaryKey(id);
        if (instance == null) {
            return null;
        }
        instance.setNode(this.nodeService.selectByPrimaryKey(instance.getNodeId()));
        HashMap<Integer, Chain> bindMap = new HashMap<>(10);
        for (Bind bind : instance.getBindList()) {
            bindMap.put(bind.getNodeId(), this.chainService.selectByPrimaryKey(bind.getChainId()));
            if (bind.getNodeId().equals(instance.getNodeId())) {
                instance.getNode().setChain(bindMap.get(instance.getNodeId()));
            }
        }
        try {
            ArrayList<Point> pointList = new ArrayList<>();
            instance.getNode().setLabel("(1,1)");
            if (bindMap.containsKey(instance.getNodeId())) {
                instance.getNode().setChain(bindMap.get(instance.getNodeId()));
            }
            Point point = new Point();
            point.setNode(instance.getNode());
            point.setLabel(instance.getNode().getLabel());
            point.setTitle(instance.getNode().getTitle());
            point.setStyle(Point.COMPLEX_STYLE);
            point.setChain(instance.getNode().getChain());
            pointList.add(point);
            buildChainTree(instance.getNode(), pointList, bindMap);
            instance.getNode().setPointList(pointList);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return instance;
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
