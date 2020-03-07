package com.paper.ssm.controller;

import com.paper.ssm.common.Controller;
import com.paper.ssm.model.dataPlane.Graph;
import com.paper.ssm.service.GraphService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RestController
@EnableAutoConfiguration
@RequestMapping("/api/graph")
public class GraphController extends Controller<Graph> {

    @Resource
    GraphService graphService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    @Override
    public List<Graph> selectListByQuery(Graph query) {
        return this.graphService.selectListByQuery(query);
    }

    @Override
    public Graph insert(Graph record) {
        return null;
    }

    @Override
    public int delete(Graph record) {
        return 0;
    }

    @Override
    public Graph update(Graph record) {
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @Override
    public Graph selectByPrimaryKey(@PathVariable Integer id) {
        return this.graphService.selectByPrimaryKey(id);
    }
}
