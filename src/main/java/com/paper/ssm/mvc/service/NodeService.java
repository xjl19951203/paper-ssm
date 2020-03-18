package com.paper.ssm.mvc.service;

import com.paper.ssm.model.structure.Graph;
import com.paper.ssm.model.structure.Node;

import javax.annotation.Resource;

/**
 * @author ZengYuan
 */
@Resource
public interface NodeService extends Service<Node> {


    /**
     * 获取结点的数据流图
     * @param id 根节点
     * @return 根节点对应的数据流图
     */
    Graph transToGraph(Integer id);

    /**
     * 获取结点的数据流图
     * @param id 根节点
     * @return 根节点对应的数据流图
     */
    Graph toGraph(Integer id);

    /** 获取结点的多叉树
     * @param id 结点id
     * @return 多叉树根节点
     */
    Node toTree(Integer id);

}
