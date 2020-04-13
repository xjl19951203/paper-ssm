package com.paper.ssm.core.dao.structure;

import com.paper.ssm.core.model.structure.Node;
import com.paper.ssm.core.dao.SQL;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author ZengYuan
 */
@Mapper
public interface NodeDao extends SQL<Node> {
}
