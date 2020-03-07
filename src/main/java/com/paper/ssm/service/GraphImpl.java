package com.paper.ssm.service;

import com.paper.ssm.mapper.GraphDao;
import com.paper.ssm.model.dataPlane.Graph;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("graphService")
public class GraphImpl implements GraphService {

    @Resource
    GraphDao graphDao;

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
        return this.graphDao.selectByPrimaryKey(id);
    }

    @Override
    public Graph selectSimpleByPrimaryKey(Integer id) {
        return null;
    }
}
