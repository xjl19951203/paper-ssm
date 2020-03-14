package com.paper.ssm.mvc.dao.normalize;

import com.paper.ssm.model.normalize.rules.Rule;
import com.paper.ssm.mvc.dao.SQL;
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
