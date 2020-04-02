package com.paper.ssm.run.graph;

import com.paper.ssm.core.dao.structure.NodeDao;
import com.paper.ssm.core.model.instantiate.Graph;
import com.paper.ssm.core.model.structure.Node;
import com.paper.ssm.core.model.structure.Pipe;
import com.paper.ssm.core.model.structure.Point;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @className: GraphImpl
 * @author: ZengYuan
 * @description:
 * @date 2020/4/2 9:47
 * @version: 1.0
 */
@Service("graphService")
public class GraphImpl implements GraphService {

    @Resource
    NodeDao nodeDao;

    @Override
    public Graph get(Integer id) {
        Node root = this.nodeDao.selectByPrimaryKey(id);
        if (root == null) {
            return null;
        }
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
                if (point.getHyperlink().getNode().getLeftPointList().size() > 0) {
                    point.setStyle(Point.COMPLEX_STYLE);
                } else {
                    point.setStyle(Point.SINGLE_STYLE);
                }
                point.setTitle(point.getHyperlink().getNode().getTitle());
                pointList.add((Point) point.clone());
                if (point.getOutputList() != null) {
                    for (Pipe outputPipe : point.getOutputList()) {
                        outputPipe.setDirection(Pipe.SIBLING_DIRECTION);
                        outputPipe.setInputLabel(point.getLabel());
                        String outputLabel = node.getLabel() + "(" + outputPipe.getOutput().getX()
                                + "," + outputPipe.getOutput().getY() + ")";
                        outputPipe.setOutputLabel(outputLabel);
                        pipeList.add((Pipe) outputPipe.clone());
                    }
                }
                /** 将每个坐标点的标签传递给与其关联的结点 */
                Node pointNode = (Node) point.getHyperlink().getNode().clone();
                pointNode.setLabel(point.getLabel());
                buildGraph(pointNode, pointList, pipeList);
            }
        }
    }
}
