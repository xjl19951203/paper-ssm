package com.paper.ssm.mvc.controller;

import com.paper.ssm.model.normalize.Chain;
import com.paper.ssm.mvc.service.ChainService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @className: ChainController
 * @author: ZengYuan
 * @description:
 * @date 2020/3/14 13:32
 * @version: 1.0
 */
@CrossOrigin
@RestController
@EnableAutoConfiguration
@RequestMapping("/api/chains")
public class ChainController extends AbstractController<Chain> {

    @Resource
    ChainService chainService;

    @Override
    public Chain insert(Chain record) {
        return null;
    }

    @Override
    public int delete(Chain record) {
        return 0;
    }

    @Override
    public Chain update(Chain record) {
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @Override
    public Chain selectByPrimaryKey(@PathVariable Integer id) {
        return this.chainService.selectByPrimaryKey(id);
    }
}
