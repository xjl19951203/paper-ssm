package com.paper.ssm.service;

import com.paper.ssm.mapper.CubeDao;
import com.paper.ssm.model.dataPlane.Bridge;
import com.paper.ssm.model.dataPlane.Cube;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
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
        Cube root = this.cubeDao.selectByPrimaryKey(id);
        if (root.getInnerBridgeList() != null) {
            root.setInnerCubeList(new ArrayList<>());
            for (Bridge bridge : root.getInnerBridgeList()) {
                root.getInnerCubeList().add(this.fillCube(bridge.getOutputId(), id));
            }
        }
        return root;
    }

    @Override
    public Cube selectSimpleByPrimaryKey(Integer id) {
        return null;
    }

    private Cube fillCube (Integer id, Integer endId) {
        Cube cube = this.cubeDao.selectByPrimaryKey(id);
        if (cube.getInnerBridgeList() != null) {
            if (cube.getInnerCubeList() == null) {
                cube.setInnerCubeList(new ArrayList<>());
            }
            for (Bridge bridge : cube.getInnerBridgeList()) {
                if (bridge.getOutputId() != null) {
                    if (bridge.getOutputId().equals(endId))
                        return null;
                    cube.getInnerCubeList().add(fillCube(bridge.getOutputId(), endId));
                }
            }
        }
        if (cube.getNextBridgeList() != null) {
            if (cube.getNextCubeList() == null) {
                cube.setNextCubeList(new ArrayList<>());
            }
            for (Bridge bridge : cube.getNextBridgeList()) {
                if (bridge.getOutputId() != null) {
                    if (bridge.getOutputId().equals(endId))
                        return null;
                    cube.getNextCubeList().add(fillCube(bridge.getOutputId(), endId));
                }
            }
        }
        return cube;
    }
}
