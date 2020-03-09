package com.paper.ssm.mvc.common;

import java.util.List;

public abstract class Controller<T> implements Service<T>  {

    public T selectSimpleByPrimaryKey(Integer id){
        return null;
    }

    public int insert(List<T> records) {
        return 0;
    }

    public Integer selectCountByQuery(T query) {
        return null;
    }

    public List<T> selectListByQuery(T query) {
        return null;
    }

    public List<T> selectListByQuery(Integer id, T query) {
        return null;
    }
}
