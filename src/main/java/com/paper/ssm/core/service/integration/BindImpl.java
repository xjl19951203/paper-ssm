package com.paper.ssm.core.service.integration;

import com.paper.ssm.core.model.integration.Bind;
import com.paper.ssm.core.dao.integration.BindDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @className: BindImpl
 * @author: ZengYuan
 * @description:
 * @date 2020/3/20 23:15
 * @version: 1.0
 */
@Service("bindService")
public class BindImpl implements BindService {

    @Resource
    BindDao bindDao;

    @Override
    public Bind insert(Bind record) {
        this.bindDao.insert(record);
        return record;
    }

    @Override
    public int insert(List<Bind> records) {
        return 0;
    }

    @Override
    public int delete(Bind record) {
        return 0;
    }

    @Override
    public Bind update(Bind record) {
        this.bindDao.update(record);
        return record;
    }

    @Override
    public List<Bind> selectListByQuery(Bind query) {
        return this.bindDao.selectListByQuery(query);
    }

    @Override
    public Integer selectCountByQuery(Bind query) {
        return null;
    }

    @Override
    public Bind selectByPrimaryKey(Integer id) {
        return this.bindDao.selectByPrimaryKey(id);
    }

    @Override
    public Bind selectSimpleByPrimaryKey(Integer id) {
        return null;
    }
}
