package com.paper.ssm.mvc.service;

import com.paper.ssm.model.structure.Edge;
import com.paper.ssm.model.structure.Line;
import com.paper.ssm.model.structure.Node;
import com.paper.ssm.model.structure.Pipe;
import com.paper.ssm.mvc.dao.structure.NodeDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
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
        return null;
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
        root = fillNode(root.getId(), true);
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
    private Node fillNode (Integer id, boolean isRoot) {
        Node node = this.nodeDao.selectByPrimaryKey(id);
        if (node == null) {
            return null;
        }
        /** 默认设置结点为单元结点*/
        node.setStyle(Node.SINGLE_STYLE);
        /** 非根节点时才处理，否则过滤兄弟结点的处理
         * 兄弟结点链
         */
        if (!isRoot && node.getPipeList() != null && node.getPipeList().size() > 0) {
            /**
             * 一旦getInnerPipeList不为null，说明该节点是复合结点
             * 其nextPipeList都应该标虚线
             */
            Integer line = Line.DOTTED_STYLE;
            if (node.getEdgeList() == null || node.getEdgeList().size() == 0) {
                line = Line.SOLID_STYLE;
            }
            for (Pipe pipe : node.getPipeList()) {
                pipe.setStyle(line);
                Node c = fillNode(pipe.getOutputId(), false);
                if (c != null) {
                    if (node.getNextList() == null) {
                        node.setNextList(new ArrayList<>());
                    }
                    node.getNextList().add(fillNode(pipe.getOutputId(), false));
                }
            }
        } else {
            node.setPipeList(null);
        }
        /**
         * 孩子结点链
         */
        node.setStyle(Node.SINGLE_STYLE);
        if (node.getEdgeList() != null && node.getEdgeList().size() > 0) {
            node.setStyle(Node.COMPLEX_STYLE);
            for (Edge edge : node.getEdgeList()) {
                /** 左内侧边界结点的pipe：粗线 */
                edge.setStyle(Line.EDGE_STYLE);
                // 通过 Bridge的side内侧边标志位，判断是否是Node的右边界
                if (edge.getSide().equals(Edge.OUTPUT_SIDE)) {
                    return node;
                }
                Node c = fillNode(edge.getChildId(), false);
                if (c != null) {
                    if (node.getChildList() == null) {
                        node.setChildList(new ArrayList<>());
                    }
                    node.getChildList().add(c);
                }
            }
        } else {
            node.setEdgeList(null);
        }
        return node;
    }
}
