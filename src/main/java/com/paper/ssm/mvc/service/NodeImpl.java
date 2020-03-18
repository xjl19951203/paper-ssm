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
        return null;
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
        return this.nodeDao.selectListByQuery(query);
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
        if (node.getPointList() != null) {
            for (Point point : node.getPointList()) {
                String inputLabel = node.getLabel() + "(" + point.getVertical() + "," + point.getHorizontal() + ")";
                point.setLabel(inputLabel);
                pointList.add((Point) point.clone());
                if (point.getOutputList() != null) {
                    for (Pipe outputPipe : point.getOutputList()) {
                        outputPipe.setInputLabel(point.getLabel());
                        String outputLabel = node.getLabel() + "(" + outputPipe.getOutput().getVertical()
                                + "," + outputPipe.getOutput().getHorizontal() + ")";
                        outputPipe.setOutputLabel(outputLabel);
                        pipeList.add((Pipe) outputPipe.clone());
                    }
                }
                /** 将每个坐标点的标签传递给与其关联的结点 */
                Node pointNode = (Node) point.getNode().clone();
                point.setTitle(pointNode.getTitle());
                pointNode.setLabel(point.getLabel());
                buildGraph(pointNode, pointList, pipeList);
            }
        }
    }


}
