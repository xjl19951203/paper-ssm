package com.paper.ssm.mvc.dao.structure;

import com.paper.ssm.model.structure.Node;
import com.paper.ssm.mvc.dao.SQL;
import org.apache.ibatis.annotations.Mapper;

/**
 * @className: HyperlinkDao
 * @author: ZengYuan
 * @description:
 * @date 2020/3/30 22:44
 * @version: 1.0
 */
@Mapper
public interface HyperlinkDao extends SQL<Node> {
}
