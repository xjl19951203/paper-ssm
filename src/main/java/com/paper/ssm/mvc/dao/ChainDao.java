package com.paper.ssm.mvc.dao;

import com.paper.ssm.model.normalize.Chain;
import org.apache.ibatis.annotations.Mapper;

/**
 * @className: ChainDao
 * @author: ZengYuan
 * @description:
 * @date 2020/3/14 11:31
 * @version: 1.0
 */
@Mapper
public interface ChainDao extends SQL<Chain> {
}
