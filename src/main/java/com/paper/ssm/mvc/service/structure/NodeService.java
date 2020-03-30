package com.paper.ssm.mvc.service.structure;

import com.paper.ssm.model.instantiate.Graph;
import com.paper.ssm.model.structure.Node;
import com.paper.ssm.mvc.service.Service;

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

}
