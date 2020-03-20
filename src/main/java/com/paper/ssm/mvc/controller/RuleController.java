package com.paper.ssm.mvc.controller;

import com.paper.ssm.model.normalize.Rule;
import com.paper.ssm.mvc.service.RuleService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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

    @RequestMapping(value = "", method = RequestMethod.GET)
    @Override
    public List<Rule> selectListByQuery(Rule query) {
        return this.ruleService.selectListByQuery(query);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @Override
    public Rule insert(@RequestBody Rule record) {
        return this.ruleService.insert(record);
    }

    @Override
    public int delete(Rule record) {
        return 0;
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    @Override
    public Rule update(@RequestBody Rule record) {
        return this.ruleService.update(record);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @Override
    public Rule selectByPrimaryKey(@PathVariable Integer id) {
        return this.ruleService.selectByPrimaryKey(id);
    }
}
