package com.paper.ssm.common;

import java.util.List;

public interface Service<T> {

    T insert(T record);

    int insert(List<T> records);

    int delete(T record);

    T update(T record);

    List<T> selectListByQuery(T query);

    Integer selectCountByQuery(T query);

    T selectByPrimaryKey(Integer id);

    T selectSimpleByPrimaryKey(Integer id);
}
