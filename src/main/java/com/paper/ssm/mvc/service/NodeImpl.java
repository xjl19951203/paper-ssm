package com.paper.ssm.mvc.service;

import com.paper.ssm.model.structure.*;
import com.paper.ssm.mvc.dao.structure.NodeDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @author ZengYuan
 */
@Service("nodeService")
public class NodeImpl implements NodeService {

    @Resource
    NodeDao nodeDao;

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
        Node root = this.nodeDao.selectByPrimaryKey(id);
        if (root == null) {
            return null;
        }
        /** 清缓存 */
        if (root.getChildList() != null) {
            root.getChildList().clear();
            root.setChildList(null);
        }
        /** 作为根节点，构造结点多叉树 */
        root = transToTree(root.getId(), true);
        return root;
    }

    @Override
    public Node selectSimpleByPrimaryKey(Integer id) {
        return null;
    }

    /**
     * 孩子兄弟链法，递归构造Multi-Level DAG多叉树
     * @param id 根节点
     * @return Node
     */
    private Node transToTree (Integer id, boolean isRoot) {
        Node node = this.nodeDao.selectByPrimaryKey(id);
        if (node == null) {
            return null;
        }
        /** 默认设置结点为单元结点*/
        node.setStyle(Node.SINGLE_STYLE);
        /** 判断当前结点是否为不可分解的叶子层结点 */
        boolean isLeafNode = (node.getChildList() == null) || (node.getChildList().size() == 0);
        /** 判断当前结点是否为右边界结点 */
        boolean isOutputNode = node.getParentEdgeList() != null && node.getParentEdgeList().size() > 0;
        /** 同时满足两个条件的右边界叶子结点，不再处理其pipeList和nextList */
        if (isLeafNode && isOutputNode) {
            node.setPipeList(null);
            return node;
        }
        /** 非根节点时才处理，否则过滤同层级结点的处理
         * 横向同层结点递归
         */
        if (!isRoot && node.getPipeList() != null && node.getPipeList().size() > 0) {
            /**
             * 一旦getInnerPipeList不为null，说明该节点是复合结点
             * 其nextPipeList都应该标虚线
             */
            Integer style = Line.COMPLEX_STYLE;
            if (node.getChildEdgeList() == null || node.getChildEdgeList().size() == 0) {
                style = Line.SINGLE_STYLE;
            }
            node.setNextList(new ArrayList<>());
            for (Pipe pipe : node.getPipeList()) {
                pipe.setStyle(style);
                Node n = transToTree(pipe.getOutputId(), false);
                if (n != null) {
                    node.getNextList().add(n);
                }
            }
        } else {
            node.setNextList(null);
            node.setPipeList(null);
        }
        /**
         * 纵向层级间结点递归
         */
        node.setStyle(Node.SINGLE_STYLE);
        if (node.getChildEdgeList() != null && node.getChildEdgeList().size() > 0) {
            node.setStyle(Node.COMPLEX_STYLE);
            node.setChildList(new ArrayList<>());
            for (Edge edge : node.getChildEdgeList()) {
                /** 左内侧边界结点的pipe：粗线 */
                edge.setStyle(Line.EDGE_STYLE);
                Node c = transToTree(edge.getChildId(), false);
                if (c != null) {
                    node.getChildList().add(c);
                }
            }
        } else {
            node.setChildList(null);
            node.setChildEdgeList(null);
        }
        return node;
    }

    @Override
    public Graph transToGraph(Integer id) {
        Node root = selectByPrimaryKey(id);
        Graph graph = new Graph();
        graph.setNodeSet(new HashSet<>());
        return null;
    }

    private Node readTree(Node node, HashSet<Integer> nodeSet, HashMap<Integer, Pipe> pipeMap) {

        if (node == null) {
            return null;
        }

        nodeSet.add(node.getId());
        if (node.getPipeList() != null && node.getPipeList().size() > 0) {
            for (Pipe pipe : node.getPipeList()) {
                pipeMap.put(pipe.getId(), pipe);
            }
        }
        return null;
    }


}
