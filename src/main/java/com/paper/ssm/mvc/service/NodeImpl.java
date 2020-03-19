package com.paper.ssm.mvc.service;

import com.paper.ssm.model.structure.*;
import com.paper.ssm.mvc.dao.structure.NodeDao;
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
    @Resource
    PipeService pipeService;

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
        return null;
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
        return this.nodeDao.selectByPrimaryKey(id);
    }

    @Override
    public Node selectSimpleByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public Graph transToGraph(Integer id) {
        Node root = this.selectByPrimaryKey(id);

        Graph graph = new Graph();
        graph.setRoot(root);
        root.setLabel("(1,1)");
        graph.setPointList(new ArrayList<>());
        Point point = new Point();
        point.setNode(root);
        point.setLabel(root.getLabel());
        point.setTitle(root.getTitle());
        if (root.getChildList().size() > 0) {
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
        if (node.getChildList() != null) {
            for (Point childPoint : node.getChildList()) {
                Pipe childPipe = new Pipe();
                childPipe.setDirection(Pipe.CHILD_DIRECTION);
                childPipe.setInputLabel(node.getLabel());
                String outputLabel = node.getLabel() + "(" + childPoint.getVertical()
                        + "," + childPoint.getHorizontal() + ")";
                childPipe.setOutputLabel(outputLabel);
                pipeList.add(childPipe);
            }
        }
        if (node.getPointList() != null) {
            for (Point point : node.getPointList()) {
                String inputLabel = node.getLabel() + "(" + point.getVertical() + "," + point.getHorizontal() + ")";
                point.setLabel(inputLabel);
                if (point.getNode().getChildList().size() > 0) {
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
                        String outputLabel = node.getLabel() + "(" + outputPipe.getOutput().getVertical()
                                + "," + outputPipe.getOutput().getHorizontal() + ")";
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
