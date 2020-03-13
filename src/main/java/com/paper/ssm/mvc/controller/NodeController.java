package com.paper.ssm.mvc.controller;

import com.paper.ssm.model.structure.Node;
import com.paper.ssm.mvc.service.NodeService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ZengYuan
 */
@CrossOrigin
@RestController
@EnableAutoConfiguration
@RequestMapping("/api/nodes")
public class NodeController extends AbstractController<Node> {

    @Resource
    NodeService nodeService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    @Override
    public List<Node> selectListByQuery(Node query) {
        return this.nodeService.selectListByQuery(query);
    }

    @Override
    public Node insert(Node record) {
        return null;
    }

    @Override
    public int delete(Node record) {
        return 0;
    }

    @Override
    public Node update(Node record) {
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @Override
    public Node selectByPrimaryKey(@PathVariable Integer id) {
        return this.nodeService.selectByPrimaryKey(id);
    }
}
