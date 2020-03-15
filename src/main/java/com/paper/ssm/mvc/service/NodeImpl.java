package com.paper.ssm.mvc.service;

import com.paper.ssm.model.structure.*;
import com.paper.ssm.mvc.dao.structure.NodeDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

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
        this.nodeDao.update(record);
        return record;
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

    @Override
    public Graph toGraph(Integer id) {
        Node root = this.nodeDao.selectByPrimaryKey(id);
        Graph graph = new Graph();
        graph.setRoot(root);
        HashMap<Integer, Node> nodeHashMap = new HashMap<>();
        Pipe queryPipe = new Pipe();
        queryPipe.setNodeId(id);
        List<Node> nodeList = new ArrayList<>();
        List<Pipe> pipeList = this.pipeService.selectListByQuery(queryPipe);
        if (pipeList == null || pipeList.size() == 0) {
            nodeList.add(root);
        }

        for (Pipe pipe : pipeList) {
            if (!nodeHashMap.containsKey(pipe.getInputId())) {
                nodeHashMap.put(pipe.getInputId(), pipe.getInput());
            }
            if (!nodeHashMap.containsKey(pipe.getOutputId())) {
                nodeHashMap.put(pipe.getOutputId(), pipe.getOutput());
            }
        }

        for (Integer key : nodeHashMap.keySet()) {
            nodeList.add(nodeHashMap.get(key));
        }

        graph.setNodeList(nodeList);
        graph.setPipeList(pipeList);
        return graph;
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
        boolean isOutputNode = node.getParentPipeList() != null && node.getParentPipeList().size() > 0;
        /** 同时满足两个条件的右边界叶子结点，不再处理其pipeList和nextList */
        if (isLeafNode && isOutputNode) {
            node.setNextList(null);
            return node;
        }
        /** 非根节点时才处理，否则过滤同层级结点的处理
         * 横向同层结点递归
         */
        if (!isRoot && node.getNextPipeList() != null && node.getNextPipeList().size() > 0) {
            /**
             * 一旦getInnerPipeList不为null，说明该节点是复合结点
             * 其nextPipeList都应该标虚线
             */
            Integer style = Pipe.COMPLEX_STYLE;
            if (node.getChildPipeList() == null || node.getChildPipeList().size() == 0) {
                style = Pipe.SINGLE_STYLE;
            }
            node.setNextList(new ArrayList<>());
            for (Pipe pipe : node.getNextPipeList()) {
                pipe.setStyle(style);
                Node n = transToTree(pipe.getOutputId(), false);
                if (n != null) {
                    node.getNextList().add(n);
                }
            }
        } else {
            node.setNextList(null);
            node.setNextPipeList(null);
        }
        /**
         * 纵向层级间结点递归
         */
        node.setStyle(Node.SINGLE_STYLE);
        if (node.getChildPipeList() != null && node.getChildPipeList().size() > 0) {
            node.setStyle(Node.COMPLEX_STYLE);
            node.setChildList(new ArrayList<>());
            for (Pipe pipe : node.getChildPipeList()) {
                /** 左内侧边界结点的pipe：粗线 */
                pipe.setStyle(Pipe.EDGE_STYLE);
                Node c = transToTree(pipe.getOutputId(), false);
                if (c != null) {
                    node.getChildList().add(c);
                }
            }
        } else {
            node.setChildList(null);
            node.setChildPipeList(null);
        }
        return node;
    }



    @Override
    public synchronized Graph transToGraph(Integer id) {
        Node root = selectByPrimaryKey(id);
        ConcurrentHashMap<Integer, Node> nodeMap = new ConcurrentHashMap<>(10);
        ConcurrentHashMap<Integer, Pipe> pipeMap = new ConcurrentHashMap<>(10);
        readTree(root, nodeMap, pipeMap);
        Graph graph = new Graph();
        graph.setRoot(root);
        graph.setNodeList(new ArrayList<>());
        graph.setPipeList(new ArrayList<>());
        for (int key : pipeMap.keySet()){
            if (pipeMap.get(key).getOutputId() == null) {
                continue;
            }
            if (nodeMap.containsKey(pipeMap.get(key).getOutputId())){
                graph.getPipeList().add(pipeMap.get(key));
            } else {
                pipeMap.remove(key);
            }
        }
        for (int key : nodeMap.keySet()){
            graph.getNodeList().add(nodeMap.get(key));
        }
        return graph;
    }


    /**
     * 遍历多叉树
     * @param node 根节点
     * @param nodeMap 结点集合
     * @param pipeMap 管道集合
     */
    private synchronized void readTree(Node node, ConcurrentHashMap<Integer, Node> nodeMap,
                                       ConcurrentHashMap<Integer, Pipe> pipeMap) {

        /** 递归终止条件 */
        if (node == null) {
            return;
        }
        /** 添加当前结点 */
        nodeMap.put(node.getId(), node);
        /** 添加当前结点的三类pipe */
        if (node.getNextPipeList() != null && node.getNextPipeList().size() > 0) {
            for (Pipe nextPipe : node.getNextPipeList()) {
                pipeMap.put(nextPipe.getId(), nextPipe);
            }
        }
        if (node.getParentPipeList() != null && node.getParentPipeList().size() > 0) {
            for (Pipe parentPipe : node.getParentPipeList()) {
                pipeMap.put(parentPipe.getId(), parentPipe);
            }
        }
        if (node.getChildPipeList() != null && node.getChildPipeList().size() > 0) {
            for (Pipe childPipe : node.getChildPipeList()) {
                pipeMap.put(childPipe.getId(), childPipe);
            }
        }
        /** 递归当前结点关联的两类结点 */
        if (node.getNextList() != null && node.getNextList().size() > 0) {
            for (Node nextNode : node.getNextList()) {
                readTree(nextNode, nodeMap, pipeMap);
            }
        }
        if (node.getChildList() != null && node.getChildList().size() > 0) {
            for (Node childNode : node.getChildList()) {
                readTree(childNode, nodeMap, pipeMap);
            }
        }
    }

}
