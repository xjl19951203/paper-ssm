package com.paper.ssm.service;

import com.paper.ssm.mapper.CubeDao;
import com.paper.ssm.model.dataPlane.Cube;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("cubeService")
public class CubeImpl implements CubeService {

    @Resource
    CubeDao cubeDao;

    @Override
    public Cube insert(Cube record) {
        return null;
    }

    @Override
    public int insert(List<Cube> records) {
        return 0;
    }

    @Override
    public int delete(Cube record) {
        return 0;
    }

    @Override
    public Cube update(Cube record) {
        return null;
    }

    @Override
    public List<Cube> selectListByQuery(Cube query) {
        return null;
    }

    @Override
    public Integer selectCountByQuery(Cube query) {
        return null;
    }

    @Override
    public Cube selectByPrimaryKey(Integer id) {
        return this.cubeDao.selectByPrimaryKey(id);
    }

    @Override
    public Cube selectSimpleByPrimaryKey(Integer id) {
        return null;
    }
}
