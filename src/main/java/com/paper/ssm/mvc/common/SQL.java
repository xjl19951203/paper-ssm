package com.paper.ssm.mvc.common;

import java.util.List;

public interface SQL<T> {

    int insert(T recode);
    int delete(T recode);
    int update(T recode);
    T selectByPrimaryKey(Integer pk);
    List<T> selectListByQuery(T query);

}
