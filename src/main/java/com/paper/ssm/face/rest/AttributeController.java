package com.paper.ssm.face.rest;

import com.paper.ssm.core.model.normalize.Attribute;
import com.paper.ssm.core.service.normalize.AttributeService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @className: BaseController
 * @author: ZengYuan
 * @description:
 * @date 2020/3/20 14:02
 * @version: 1.0
 */
@CrossOrigin
@RestController
@EnableAutoConfiguration
@RequestMapping("/api/normalize/attributes")
public class AttributeController extends AbstractController<Attribute> {

    @Resource
    AttributeService attributeService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    @Override
    public Attribute insert(@RequestBody Attribute record) {
        return this.attributeService.insert(record);
    }

    @Override
    public int delete(Attribute record) {
        return 0;
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    @Override
    public Attribute update(@RequestBody Attribute record) {
        return this.attributeService.update(record);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    @Override
    public List<Attribute> selectListByQuery(Attribute query) {
        return this.attributeService.selectListByQuery(query);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @Override
    public Attribute selectByPrimaryKey(@PathVariable Integer id) {
        return this.attributeService.selectByPrimaryKey(id);
    }
}
