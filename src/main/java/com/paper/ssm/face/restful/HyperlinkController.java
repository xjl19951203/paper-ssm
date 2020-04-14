package com.paper.ssm.face.restful;

import com.paper.ssm.core.model.structure.Hyperlink;
import com.paper.ssm.core.service.structure.HyperlinkService;
import com.paper.ssm.core.service.structure.NodeService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @className: HyperlinkController
 * @author: ZengYuan
 * @description:
 * @date 2020/4/14 15:38
 * @version: 1.0
 */
@CrossOrigin
@RestController
@EnableAutoConfiguration
@RequestMapping("/api/structure/hyperlinks")
public class HyperlinkController extends AbstractController<Hyperlink>{

    @Resource
    HyperlinkService hyperlinkService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    @Override
    public Hyperlink insert(@RequestBody Hyperlink record) {
        return this.hyperlinkService.insert(record);
    }

    @Override
    public int delete(Hyperlink record) {
        return 0;
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    @Override
    public Hyperlink update(@RequestBody Hyperlink record) {
        return this.hyperlinkService.update(record);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    @Override
    public List<Hyperlink> selectListByQuery(Hyperlink query) {
        return this.hyperlinkService.selectListByQuery(query);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @Override
    public Hyperlink selectByPrimaryKey(@PathVariable Integer id) {
        return this.hyperlinkService.selectByPrimaryKey(id);
    }
}
