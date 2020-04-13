package com.paper.ssm.core.dao.structure;

import com.paper.ssm.core.model.structure.Point;
import com.paper.ssm.core.dao.SQL;
import org.apache.ibatis.annotations.Mapper;

/**
 * @className: PointDao
 * @author: ZengYuan
 * @description:
 * @date 2020/3/18 19:57
 * @version: 1.0
 */
@Mapper
public interface PointDao extends SQL<Point> {
}
