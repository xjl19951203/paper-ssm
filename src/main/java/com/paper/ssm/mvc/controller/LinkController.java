package com.paper.ssm.mvc.controller;

import com.paper.ssm.model.normalize.Link;
import com.paper.ssm.mvc.service.LinkService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @className: LinkController
 * @author: ZengYuan
 * @description:
 * @date 2020/3/20 19:06
 * @version: 1.0
 */
@CrossOrigin
@RestController
@EnableAutoConfiguration
@RequestMapping("/api/links")
public class LinkController extends AbstractController<Link> {

    @Resource
    LinkService linkService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    @Override
    public Link insert(@RequestBody Link record) {
        return this.linkService.insert(record);
    }

    @Override
    public int delete(Link record) {
        return 0;
    }

    @Override
    public Link update(Link record) {
        return null;
    }

    @Override
    public Link selectByPrimaryKey(Integer id) {
        return null;
    }
}
