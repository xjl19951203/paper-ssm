package com.paper.ssm.mvc.dao.normalize;

import com.paper.ssm.model.normalize.Link;
import com.paper.ssm.mvc.dao.SQL;
import org.apache.ibatis.annotations.Mapper;

/**
 * @className: LinkDao
 * @author: ZengYuan
 * @description:
 * @date 2020/3/16 17:07
 * @version: 1.0
 */
@Mapper
public interface LinkDao extends SQL<Link> {
}
