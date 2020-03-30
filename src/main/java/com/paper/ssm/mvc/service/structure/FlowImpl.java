package com.paper.ssm.mvc.service.structure;

import com.paper.ssm.model.structure.Flow;
import com.paper.ssm.mvc.dao.structure.FlowDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @className: FlowImpl
 * @author: ZengYuan
 * @description:
 * @date 2020/3/17 23:06
 * @version: 1.0
 */
@Service("flowService")
public class FlowImpl implements FlowService {

    @Resource
    FlowDao flowDao;

    @Override
    public Flow insert(Flow record) {
        return null;
    }

    @Override
    public int insert(List<Flow> records) {
        return 0;
    }

    @Override
    public int delete(Flow record) {
        return 0;
    }

    @Override
    public Flow update(Flow record) {
        return null;
    }

    @Override
    public List<Flow> selectListByQuery(Flow query) {
        return null;
    }

    @Override
    public Integer selectCountByQuery(Flow query) {
        return null;
    }

    @Override
    public Flow selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public Flow selectSimpleByPrimaryKey(Integer id) {
        return null;
    }
}
