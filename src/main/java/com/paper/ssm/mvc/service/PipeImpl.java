package com.paper.ssm.mvc.service;

import com.paper.ssm.model.structure.Pipe;
import com.paper.ssm.mvc.dao.structure.PipeDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @className: PipeImpl
 * @author: ZengYuan
 * @description:
 * @date 2020/3/15 16:48
 * @version: 1.0
 */
@Service("pipeService")
public class PipeImpl implements PipeService{

    @Resource
    PipeDao pipeDao;

    @Override
    public Pipe insert(Pipe record) {
        this.pipeDao.insert(record);
        return record;
    }

    @Override
    public int insert(List<Pipe> records) {
        return 0;
    }

    @Override
    public int delete(Pipe record) {
        return this.pipeDao.delete(record);
    }

    @Override
    public Pipe update(Pipe record) {
        this.pipeDao.update(record);
        return record;
    }

    @Override
    public List<Pipe> selectListByQuery(Pipe query) {
        return null;
    }

    @Override
    public Integer selectCountByQuery(Pipe query) {
        return null;
    }

    @Override
    public Pipe selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public Pipe selectSimpleByPrimaryKey(Integer id) {
        return null;
    }
}
