package com.paper.ssm.core.service.structure;

import com.paper.ssm.core.model.structure.*;
import com.paper.ssm.core.dao.structure.NodeDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author ZengYuan
 */
@Service("nodeService")
public class NodeImpl implements NodeService {

    @Resource
    NodeDao nodeDao;

    @Override
    public Node insert(Node record) {
        this.nodeDao.insert(record);
        return record;
    }

    @Override
    public int insert(List<Node> records) {
        return 0;
    }

    @Override
    public int delete(Node record) {
        return 0;
    }

    @Override
    public Node update(Node record) {
        this.nodeDao.update(record);
        return record;
    }

    @Override
    public List<Node> selectListByQuery(Node query) {
        List<Node> nodeList = this.nodeDao.selectListByQuery(query);
        for (Node node : nodeList) {
            if (node.getPointList().size() > 0) {
                node.setStyle(Point.COMPLEX_STYLE);
            } else {
                node.setStyle(Point.SINGLE_STYLE);
            }
        }
        return nodeList;
    }

    @Override
    public Integer selectCountByQuery(Node query) {
        return null;
    }

    @Override
    public Node selectByPrimaryKey(Integer id) {
        Node root = this.nodeDao.selectByPrimaryKey(id);
        if (root == null) {
            return null;
        }
        HashMap<Integer, Node> nodeHashMap = new HashMap<>(10);
        root.setNodeList(new ArrayList<>());
        countNode(root, nodeHashMap, root.getNodeList());
        return root;
    }

    private void countNode(Node node, HashMap<Integer, Node> nodeHashMap, List<Node> nodeList) {
        if (node == null || node.getPointList() == null) {
            return;
        }
        for (Point point : node.getPointList()) {
            if (!nodeHashMap.containsKey(point.getHyperlink().getNodeId())) {
                nodeHashMap.put(point.getHyperlink().getNodeId(), point.getHyperlink().getNode());
                nodeList.add(point.getHyperlink().getNode());
                countNode(point.getHyperlink().getNode(), nodeHashMap, nodeList);
            }
        }
    }

    @Override
    public Node selectSimpleByPrimaryKey(Integer id) {
        return null;
    }


}
