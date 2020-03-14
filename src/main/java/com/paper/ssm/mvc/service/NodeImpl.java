package com.paper.ssm.mvc.service;

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
        if (root.getInnerNodeList() != null) {
            root.getInnerNodeList().clear();
        }
        root.setType(Node.SINGLE_TYPE);
        if (root.getInnerPipeList() != null) {
            root.setType(Node.COMPLEX_TYPE);
            for (Pipe pipe : root.getInnerPipeList()) {
                /** 左内侧边界结点的pipe：粗线 */
                pipe.setLine(Pipe.BOLD_LINE);
                if (root.getInnerNodeList() == null) {
                    root.setInnerNodeList(new ArrayList<>());
                }
                root.getInnerNodeList().add(this.fillNode(pipe.getOutputId()));
            }
        }
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
    private Node fillNode (Integer id) {
        Node node = this.nodeDao.selectByPrimaryKey(id);
        if (node == null) {
            return null;
        }
        /** 默认设置结点为单元结点*/
        node.setType(Node.SINGLE_TYPE);
        // 兄弟结点链
        if (node.getNextPipeList() != null && node.getNextPipeList().size() > 0) {
            /**
             * 一旦getInnerPipeList不为null，说明该节点是复合结点
             * 其nextPipeList都应该标虚线
             */
            Integer line = Pipe.DOTTED_LINE;
            if (node.getInnerPipeList() == null || node.getInnerPipeList().size() == 0) {
                line = Pipe.SOLID_LINE;
            }
            for (Pipe pipe : node.getNextPipeList()) {
                pipe.setLine(line);
                Node c = fillNode(pipe.getOutputId());
                if (c != null) {
                    if (node.getNextNodeList() == null) {
                        node.setNextNodeList(new ArrayList<>());
                    }
                    node.getNextNodeList().add(fillNode(pipe.getOutputId()));
                }
            }
        }
        /**
         * 孩子结点链
         */
        node.setType(Node.SINGLE_TYPE);
        if (node.getInnerPipeList() != null && node.getInnerPipeList().size() > 0) {
            node.setType(Node.COMPLEX_TYPE);
            for (Pipe pipe : node.getInnerPipeList()) {
                /** 左内侧边界结点的pipe：粗线 */
                pipe.setLine(Pipe.BOLD_LINE);
                // 通过 Bridge的side内侧边标志位，判断是否是Node的右边界
                if (pipe.getSide().equals(Pipe.INNER_OUTPUT_SIDE)) {
                    return node;
                }
                Node c = fillNode(pipe.getOutputId());
                if (c != null) {
                    if (node.getInnerNodeList() == null) {
                        node.setInnerNodeList(new ArrayList<>());
                    }
                    node.getInnerNodeList().add(c);
                }
            }
        }
        return node;
    }
}
