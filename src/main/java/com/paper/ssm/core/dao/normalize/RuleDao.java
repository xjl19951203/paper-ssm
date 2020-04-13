package com.paper.ssm.core.dao.normalize;

import com.paper.ssm.core.model.normalize.Rule;
import com.paper.ssm.core.dao.SQL;
import org.apache.ibatis.annotations.Mapper;

/**
 * @className: RuleDao
 * @author: ZengYuan
 * @description:
 * @date 2020/3/9 19:45
 * @version: 1.0
 */
@Mapper
public interface RuleDao extends SQL<Rule> {
}
