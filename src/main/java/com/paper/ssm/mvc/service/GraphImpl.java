package com.paper.ssm.mvc.service;

import com.paper.ssm.model.structure.Node;
import com.paper.ssm.model.structure.Pipe;
import com.paper.ssm.model.structure.Graph;
import com.paper.ssm.model.task.Data;
import com.paper.ssm.mvc.dao.structure.GraphDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ZengYuan
 */
@Service("graphService")
public class GraphImpl implements GraphService {

    @Resource
    GraphDao graphDao;
    @Resource
    NodeService nodeService;

    @Override
    public Graph insert(Graph record) {
        return null;
    }

    @Override
    public int insert(List<Graph> records) {
        return 0;
    }

    @Override
    public int delete(Graph record) {
        return 0;
    }

    @Override
    public Graph update(Graph record) {
        return null;
    }

    @Override
    public List<Graph> selectListByQuery(Graph query) {
        return this.graphDao.selectListByQuery(query);
    }

    @Override
    public Integer selectCountByQuery(Graph query) {
        return null;
    }

    @Override
    public Graph selectByPrimaryKey(Integer id) {
        Graph root = this.graphDao.selectByPrimaryKey(id);
        if (root == null) {
            return null;
        }
        if (root.getInnerPipeList() != null) {
            if (root.getInnerDataList() == null) {
                root.setInnerDataList(new ArrayList<>());
            }
            for (Pipe pipe : root.getInnerPipeList()) {
            }
        }
        return root;
    }

    @Override
    public Graph selectSimpleByPrimaryKey(Integer id) {
        return null;
    }

    private Node fillGraph(Integer dataId) {
        return null;
    }
}
