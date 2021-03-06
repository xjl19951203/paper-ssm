package com.paper.ssm.core.dao;

import java.util.List;

/**
 * @author ZengYuan
 */
public interface SQL<T> {

    int insert(T recode);
    int insertList(List<T> recodes);
    int delete(T recode);
    int update(T recode);
    T selectSimpleByPrimaryKey(Integer pk);
    T selectByPrimaryKey(Integer pk);
    List<T> selectListByQuery(T query);

}
