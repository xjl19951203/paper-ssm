package com.paper.ssm.controller;

import com.paper.ssm.common.Controller;
import com.paper.ssm.model.dataPlane.Cube;
import com.paper.ssm.service.CubeService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RestController
@EnableAutoConfiguration
@RequestMapping("/api/cube")
public class CubeController extends Controller<Cube> {

    @Resource
    CubeService cubeService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    @Override
    public List<Cube> selectListByQuery(Cube query) {
        return this.cubeService.selectListByQuery(query);
    }

    @Override
    public Cube insert(Cube record) {
        return null;
    }

    @Override
    public int delete(Cube record) {
        return 0;
    }

    @Override
    public Cube update(Cube record) {
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @Override
    public Cube selectByPrimaryKey(@PathVariable Integer id) {
        return this.cubeService.selectByPrimaryKey(id);
    }
}
