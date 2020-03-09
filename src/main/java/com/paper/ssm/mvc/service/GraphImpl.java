package com.paper.ssm.mvc.service;

import com.paper.ssm.model.structure.line.Edge;
import com.paper.ssm.model.structure.line.Line;
import com.paper.ssm.model.structure.line.Pipe;
import com.paper.ssm.model.structure.graph.Graph;
import com.paper.ssm.model.structure.node.Data;
import com.paper.ssm.mvc.dao.structure.GraphDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("graphService")
public class GraphImpl implements GraphService {

    @Resource
    GraphDao graphDao;
    @Resource
    DataService dataService;

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
        if (root.getInnerEdgeList() != null) {
            if (root.getInnerDataList() == null) {
                root.setInnerDataList(new ArrayList<>());
            }
            for (Edge edge : root.getInnerEdgeList()) {
                root.getInnerDataList().add(fillGraph(edge.getDataId()));
            }
        }
        return root;
    }

    @Override
    public Graph selectSimpleByPrimaryKey(Integer id) {
        return null;
    }

    private Data fillGraph(Integer dataId) {
        Data data = this.dataService.selectByPrimaryKey(dataId);
        if (data == null) {
            return null;
        }
        // 该if判断是递归终止条件，其实只要data存在innerEdgeList就说明该Data是右侧结点，可以终止了
        if (data.getInnerEdgeList() != null) {
            for (Edge edge : data.getInnerEdgeList()) {
                if (edge.getSide().equals(Line.INNER_OUTPUT_SIDE)) {
                    return data;
                }
            }
        }
        if (data.getNextPipeList() != null) {
            if (data.getNextDataList() == null) {
                data.setNextDataList(new ArrayList<>());
            }
            for (Pipe pipe : data.getNextPipeList()) {
                data.getNextDataList().add(fillGraph(pipe.getOutputId()));
            }
        }
        return data;
    }
}
