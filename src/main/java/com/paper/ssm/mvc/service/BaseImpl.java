package com.paper.ssm.mvc.service;

import com.paper.ssm.model.normalize.Base;
import com.paper.ssm.mvc.dao.normalize.BaseDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @className: BaseImpl
 * @author: ZengYuan
 * @description:
 * @date 2020/3/20 13:50
 * @version: 1.0
 */
@Service("baseService")
public class BaseImpl implements BaseService {

    @Resource
    BaseDao baseDao;

    @Override
    public Base insert(Base record) {
        this.baseDao.insert(record);
        return record;
    }

    @Override
    public int insert(List<Base> records) {
        return 0;
    }

    @Override
    public int delete(Base record) {
        return 0;
    }

    @Override
    public Base update(Base record) {
        this.baseDao.update(record);
        return record;
    }

    @Override
    public List<Base> selectListByQuery(Base query) {
        return this.baseDao.selectListByQuery(query);
    }

    @Override
    public Integer selectCountByQuery(Base query) {
        return null;
    }

    @Override
    public Base selectByPrimaryKey(Integer id) {
        return this.baseDao.selectByPrimaryKey(id);
    }

    @Override
    public Base selectSimpleByPrimaryKey(Integer id) {
        return null;
    }
}
