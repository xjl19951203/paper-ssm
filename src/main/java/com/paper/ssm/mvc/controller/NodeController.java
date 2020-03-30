package com.paper.ssm.mvc.controller;

import com.paper.ssm.model.instantiate.Graph;
import com.paper.ssm.model.structure.Node;
import com.paper.ssm.mvc.service.structure.NodeService;
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
public class NodeController extends AbstractController<Node> implements Cloneable{

    @Resource
    NodeService nodeService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    @Override
    public List<Node> selectListByQuery(Node query) {
        return this.nodeService.selectListByQuery(query);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @Override
    public Node insert(@RequestBody Node record) {
        return this.nodeService.insert(record);
    }

    @Override
    public int delete(Node record) {
        return 0;
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    @Override
    public Node update(@RequestBody Node record) {
        return this.nodeService.update(record);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @Override
    public Node selectByPrimaryKey(@PathVariable Integer id) {
        return this.nodeService.selectByPrimaryKey(id);
    }

    @RequestMapping(value = "/{id}/graph", method = RequestMethod.GET)
    public Graph getGraph(@PathVariable Integer id) {
        return this.nodeService.transToGraph(id);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
