package com.paper.ssm.core.dao.structure;

import com.paper.ssm.core.model.structure.Hyperlink;
import com.paper.ssm.core.dao.SQL;
import org.apache.ibatis.annotations.Mapper;

/**
 * @className: HyperlinkDao
 * @author: ZengYuan
 * @description:
 * @date 2020/3/30 22:44
 * @version: 1.0
 */
@Mapper
public interface HyperlinkDao extends SQL<Hyperlink> {

    /**
     * 根据坐标主键查询唯一的（第一条）超链接
     * @param pointId 超链接关联的坐标
     * @return 唯一的超链接
     */
    Hyperlink selectByPointId(Integer pointId);

}
