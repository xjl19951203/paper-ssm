package com.paper.ssm.mvc.controller;

import com.paper.ssm.mvc.service.Service;

import java.util.List;

/**
 * @author ZengYuan
 */
public abstract class AbstractController<T> implements Service<T> {

    @Override
    public T selectSimpleByPrimaryKey(Integer id){
        return null;
    }

    @Override
    public int insert(List<T> records) {
        return 0;
    }

    @Override
    public Integer selectCountByQuery(T query) {
        return null;
    }

    @Override
    public List<T> selectListByQuery(T query) {
        return null;
    }

    public List<T> selectListByQuery(Integer id, T query) {
        return null;
    }
}
