package com.paper.ssm.mvc.service;

import com.paper.ssm.mvc.mapper.structure.CubeDao;
import com.paper.ssm.model.structure.Line.Bridge;
import com.paper.ssm.model.structure.node.Cube;
import com.paper.ssm.model.structure.Line.Line;
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
        if (root == null) {
            return null;
        }
        if (root.getInnerCubeList() != null) {
            root.getInnerCubeList().clear();
        }
        if (root.getInnerBridgeList() != null) {
            for (Bridge bridge : root.getInnerBridgeList()) {
                if (root.getInnerCubeList() == null) {
                    root.setInnerCubeList(new ArrayList<>());
                }
                root.getInnerCubeList().add(this.fillCube(bridge.getOutputId()));
            }
        }
        return root;
    }

    @Override
    public Cube selectSimpleByPrimaryKey(Integer id) {
        return null;
    }

    /**
     * 孩子兄弟链法，递归构造Multi-Level DAG多叉树
     * @param id 根节点
     * @return Cube
     */
    private Cube fillCube (Integer id) {
        Cube cube = this.cubeDao.selectByPrimaryKey(id);
        if (cube == null) {
            return null;
        }
        // 兄弟结点链
        if (cube.getNextBridgeList() != null) {
            for (Bridge bridge : cube.getNextBridgeList()) {
                Cube c = fillCube(bridge.getOutputId());
                if (c != null) {
                    if (cube.getNextCubeList() == null) {
                        cube.setNextCubeList(new ArrayList<>());
                    }
                    cube.getNextCubeList().add(fillCube(bridge.getOutputId()));
                }
            }
        }
        // 孩子结点链
        if (cube.getInnerBridgeList() != null) {
            for (Bridge bridge : cube.getInnerBridgeList()) {
                // 通过 Bridge的side内侧边标志位，判断是否是Cube的右边界
                if (bridge.getSide().equals(Line.INNER_OUTPUT_SIDE)) {
                    return cube;
                }
                Cube c = fillCube(bridge.getOutputId());
                if (c != null) {
                    if (cube.getInnerCubeList() == null) {
                        cube.setInnerCubeList(new ArrayList<>());
                    }
                    cube.getInnerCubeList().add(c);
                }
            }
        }
        return cube;
    }
}
