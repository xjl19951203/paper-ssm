package com.paper.ssm.core.dao.normalize;

import com.paper.ssm.core.dao.SQL;
import com.paper.ssm.core.model.normalize.AttrRef;
import com.paper.ssm.core.model.normalize.InfoRef;
import org.apache.ibatis.annotations.Mapper;

/**
 * @className: LinkDao
 * @author: ZengYuan
 * @description:
 * @date 2020/3/16 17:07
 * @version: 1.0
 */
@Mapper
public interface AttrRefDao extends SQL<AttrRef> {
}
