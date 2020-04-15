package com.paper.ssm.face.restful;

import com.paper.ssm.core.model.normalize.InfoRef;
import com.paper.ssm.core.service.normalize.InfoRefService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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
@RequestMapping("/api/normalize/inforefs")
public class InfoRefController extends AbstractController<InfoRef> {

    @Resource
    InfoRefService infoRefService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    @Override
    public InfoRef insert(@RequestBody InfoRef record) {
        return this.infoRefService.insert(record);
    }

    @Override
    public int delete(InfoRef record) {
        return 0;
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    @Override
    public InfoRef update(@RequestBody InfoRef record) {
        return this.infoRefService.update(record);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    @Override
    public List<InfoRef> selectListByQuery(InfoRef query) {
        return this.infoRefService.selectListByQuery(query);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @Override
    public InfoRef selectByPrimaryKey(@PathVariable Integer id) {
        return this.infoRefService.selectByPrimaryKey(id);
    }
}
