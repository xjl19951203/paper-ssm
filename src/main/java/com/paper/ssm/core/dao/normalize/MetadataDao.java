package com.paper.ssm.core.dao.normalize;

import com.paper.ssm.core.dao.SQL;
import com.paper.ssm.core.model.normalize.Metadata;
import org.apache.ibatis.annotations.Mapper;

/**
 * @className: Metadata
 * @author: ZengYuan
 * @description:
 * @date 2020/4/12 23:55
 * @version: 1.0
 */
@Mapper
public interface MetadataDao extends SQL<Metadata> {
}
