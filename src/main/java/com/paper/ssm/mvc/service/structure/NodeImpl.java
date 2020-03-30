package com.paper.ssm.mvc.service.structure;

import com.paper.ssm.model.instantiate.Graph;
import com.paper.ssm.model.structure.*;
import com.paper.ssm.mvc.dao.structure.NodeDao;
import com.paper.ssm.mvc.service.instantiate.BindService;
import com.paper.ssm.mvc.service.normalize.ChainService;
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
        HashMap<Integer, Node> nodeHashMap = new HashMap<>(10);
        root.setNodeList(new ArrayList<>());
        countNode(root, nodeHashMap, root.getNodeList());
        return root;
    }

    private void countNode(Node node, HashMap<Integer, Node> nodeHashMap, List<Node> nodeList) {
        if (node == null) {
            return;
        }
        for (Point point : node.getPointList()) {
            if (!nodeHashMap.containsKey(point.getNodeId())) {
                nodeHashMap.put(point.getNodeId(), point.getNode());
                nodeList.add(point.getNode());
                countNode(point.getNode(), nodeHashMap, nodeList);
            }
        }
    }

    @Override
    public Node selectSimpleByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public Graph transToGraph(Integer id) {
        Node root = this.nodeDao.selectByPrimaryKey(id);
        Graph graph = new Graph();
        graph.setRoot(root);
        root.setLabel("(1,1)");
        graph.setPointList(new ArrayList<>());
        Point point = new Point();
        point.setNode(root);
        point.setLabel(root.getLabel());
        point.setTitle(root.getTitle());
        if (root.getLeftPointList().size() > 0) {
            point.setStyle(Point.COMPLEX_STYLE);
        } else {
            point.setStyle(Point.SINGLE_STYLE);
        }
        graph.getPointList().add(point);
        graph.setPipeList(new ArrayList<>());
        try {
            buildGraph(root, graph.getPointList(), graph.getPipeList());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return graph;
    }

    public void buildGraph(Node node, List<Point> pointList, List<Pipe> pipeList) throws CloneNotSupportedException {
        if (node == null) {
            return;
        }
        if (node.getLeftPointList() != null) {
            for (Point childPoint : node.getLeftPointList()) {
                Pipe childPipe = new Pipe();
                childPipe.setDirection(Pipe.CHILD_DIRECTION);
                childPipe.setInputLabel(node.getLabel());
                String outputLabel = node.getLabel() + "(" + childPoint.getX()
                        + "," + childPoint.getY() + ")";
                childPipe.setOutputLabel(outputLabel);
                pipeList.add(childPipe);
            }
        }
        if (node.getPointList() != null) {
            for (Point point : node.getPointList()) {
                String inputLabel = node.getLabel() + "(" + point.getX() + "," + point.getY() + ")";
                point.setLabel(inputLabel);
                if (point.getNode().getLeftPointList().size() > 0) {
                    point.setStyle(Point.COMPLEX_STYLE);
                } else {
                    point.setStyle(Point.SINGLE_STYLE);
                }
                point.setTitle(point.getNode().getTitle());
                pointList.add((Point) point.clone());
                if (point.getOutputList() != null) {
                    for (Pipe outputPipe : point.getOutputList()) {
                        outputPipe.setDirection(Pipe.NEXT_DIRECTION);
                        outputPipe.setInputLabel(point.getLabel());
                        String outputLabel = node.getLabel() + "(" + outputPipe.getOutput().getX()
                                + "," + outputPipe.getOutput().getY() + ")";
                        outputPipe.setOutputLabel(outputLabel);
                        pipeList.add((Pipe) outputPipe.clone());
                    }
                }
                /** 将每个坐标点的标签传递给与其关联的结点 */
                Node pointNode = (Node) point.getNode().clone();
                pointNode.setLabel(point.getLabel());
                buildGraph(pointNode, pointList, pipeList);
            }
        }
    }


}
