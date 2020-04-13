package com.paper.ssm.core.dao.normalize;

import com.paper.ssm.core.dao.SQL;
import com.paper.ssm.core.model.normalize.Information;
import org.apache.ibatis.annotations.Mapper;

/**
 * @className: InformationDao
 * @author: ZengYuan
 * @description:
 * @date 2020/4/12 23:57
 * @version: 1.0
 */
@Mapper
public interface InformationDao extends SQL<Information> {
}
