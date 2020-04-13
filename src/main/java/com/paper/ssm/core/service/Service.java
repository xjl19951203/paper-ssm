package com.paper.ssm.core.service;

import java.util.List;

/**
 * @author ZengYuan
 */
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
