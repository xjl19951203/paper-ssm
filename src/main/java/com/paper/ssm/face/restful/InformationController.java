package com.paper.ssm.face.restful;

import com.paper.ssm.core.model.normalize.Information;
import com.paper.ssm.core.service.normalize.InformationService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @className: InformationController
 * @author: ZengYuan
 * @description:
 * @date 2020/4/13 9:07
 * @version: 1.0
 */
@CrossOrigin
@RestController
@EnableAutoConfiguration
@RequestMapping("/api/informations")
public class InformationController extends AbstractController<Information>  {

    @Resource
    InformationService informationService;

    @Override
    public Information insert(Information record) {
        return null;
    }

    @Override
    public int delete(Information record) {
        return 0;
    }

    @Override
    public Information update(Information record) {
        return null;
    }


    @RequestMapping(value = "", method = RequestMethod.GET)
    @Override
    public List<Information> selectListByQuery(Information query) {
        return this.informationService.selectListByQuery(query);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @Override
    public Information selectByPrimaryKey(@PathVariable Integer id) {
        return this.informationService.selectByPrimaryKey(id);
    }
}
