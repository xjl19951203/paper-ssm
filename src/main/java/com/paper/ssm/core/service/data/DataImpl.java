package com.paper.ssm.core.service.data;

import com.paper.ssm.core.model.data.Data;
import com.paper.ssm.core.model.normalize.Chain;
import com.paper.ssm.run.drools.DroolsService;
import com.paper.ssm.run.graph.GraphService;
import com.paper.ssm.run.influx.InfluxService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * @author ZengYuan
 */
@Service("dataService")
public class DataImpl implements DataService {

    @Resource
    GraphService graphService;
    @Resource
    DroolsService droolsService;
    @Resource
    InfluxService influxService;

    @Override
    public Data insert(Data data) {
        this.droolsService.run(data, null);
        this.influxService.insert(data);
        return data;
    }
}
