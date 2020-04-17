package com.paper.ssm.face.rest;

import com.paper.ssm.core.model.normalize.Metadata;
import com.paper.ssm.core.service.normalize.MetadataService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @className: MetadataController
 * @author: ZengYuan
 * @description:
 * @date 2020/4/14 22:18
 * @version: 1.0
 */
@CrossOrigin
@RestController
@EnableAutoConfiguration
@RequestMapping("/api/normalize/metadatas")
public class MetadataController extends AbstractController<Metadata>{

    @Resource
    MetadataService metadataService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    @Override
    public Metadata insert(@RequestBody Metadata record) {
        return this.metadataService.insert(record);
    }

    @Override
    public int delete(Metadata record) {
        return 0;
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    @Override
    public Metadata update(@RequestBody Metadata record) {
        return this.metadataService.update(record);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    @Override
    public List<Metadata> selectListByQuery(Metadata query) {
        return this.metadataService.selectListByQuery(query);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @Override
    public Metadata selectByPrimaryKey(@PathVariable Integer id) {
        return this.metadataService.selectByPrimaryKey(id);
    }
}
