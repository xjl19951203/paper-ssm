package com.paper.ssm.service;

import com.paper.ssm.mapper.DataDao;
import com.paper.ssm.model.dataPlane.Data;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("dataService")
public class DataImpl implements DataService {

    @Resource
    DataDao dataDao;

    @Override
    public Data insert(Data record) {
        return null;
    }

    @Override
    public int insert(List<Data> records) {
        return 0;
    }

    @Override
    public int delete(Data record) {
        return 0;
    }

    @Override
    public Data update(Data record) {
        return null;
    }

    @Override
    public List<Data> selectListByQuery(Data query) {
        return null;
    }

    @Override
    public Integer selectCountByQuery(Data query) {
        return null;
    }

    @Override
    public Data selectByPrimaryKey(Integer id) {
        return this.dataDao.selectByPrimaryKey(id);
    }

    @Override
    public Data selectSimpleByPrimaryKey(Integer id) {
        return null;
    }
}
