package com.paper.ssm.mvc.service;

import com.paper.ssm.mvc.mapper.structure.DataDao;
import com.paper.ssm.model.structure.node.Data;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
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
        Data data = this.dataDao.selectByPrimaryKey(id);
        if (data.getRuleList() == null) {
            data.setRuleList(new ArrayList<>());
        }
        if (data.getRange() != null)
            data.getRuleList().add(data.getRange());
        if (data.getDefaultValue() != null)
            data.getRuleList().add(data.getDefaultValue());
        if (data.getType() != null)
            data.getRuleList().add(data.getType());
        if (data.getUnit() != null)
            data.getRuleList().add(data.getUnit());
        return data;
    }

    @Override
    public Data selectSimpleByPrimaryKey(Integer id) {
        return null;
    }
}
