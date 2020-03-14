package com.paper.ssm.mvc.controller;

import com.paper.ssm.model.normalize.rules.Rule;
import com.paper.ssm.mvc.service.RuleService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @className: RuleController
 * @author: ZengYuan
 * @description:
 * @date 2020/3/9 20:14
 * @version: 1.0
 */
@CrossOrigin
@RestController
@EnableAutoConfiguration
@RequestMapping("/api/rules")
public class RuleController extends AbstractController<Rule> {

    @Resource
    RuleService ruleService;

    @Override
    public Rule insert(Rule record) {
        return null;
    }

    @Override
    public int delete(Rule record) {
        return 0;
    }

    @Override
    public Rule update(Rule record) {
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @Override
    public Rule selectByPrimaryKey(@PathVariable Integer id) {
        return this.ruleService.selectByPrimaryKey(id);
    }
}
