package com.paper.ssm.common;

public interface SQL<T> {

    int insert(T recode);
    int delete(T recode);
    int update(T recode);
    T selectByPrimaryKey(Integer pk);

}
