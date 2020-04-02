package com.paper.ssm.run.graph;

import com.paper.ssm.core.model.instantiate.Graph;

/**
 * @className: GraphService
 * @author: ZengYuan
 * @description:
 * @date 2020/4/2 9:47
 * @version: 1.0
 */
public interface GraphService {

    /**
     * 获取结点的数据流图
     * @param id 根节点
     * @return 根节点对应的数据流图
     */
    Graph get(Integer id);
}
