package com.paper.ssm.mvc.dao.structure;

import com.paper.ssm.model.structure.Node;
import com.paper.ssm.mvc.dao.SQL;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author ZengYuan
 */
@Mapper
public interface NodeDao extends SQL<Node> {
}
