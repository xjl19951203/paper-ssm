package com.paper.ssm.core.service.data;

import com.paper.ssm.core.model.data.Data;
import com.paper.ssm.core.model.instantiate.Instance;
import com.paper.ssm.core.model.normalize.Chain;
import com.paper.ssm.core.model.structure.Point;
import com.paper.ssm.core.service.instantiate.InstanceService;
import com.paper.ssm.run.drools.DroolsService;
import com.paper.ssm.run.influx.InfluxService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;


/**
 * @author ZengYuan
 */
@Service("dataService")
public class DataImpl implements DataService {

    @Resource
    InstanceService instanceService;
    @Resource
    DroolsService droolsService;
    @Resource
    InfluxService influxService;

    @Override
    public Data insert(Data data) {
        Chain chain = getChain(data);
        this.droolsService.run(data, chain);
        this.influxService.insert(data);
        return data;
    }

    private Chain getChain(Data data) {
        System.out.println(data.getInstanceId());
        Instance instance = this.instanceService.selectByPrimaryKey(data.getInstanceId());
        for (Point point : instance.getNode().getPointList()) {
            if (point.getId().equals(data.getPointId()) &&
                    point.getLabel().equals(data.getPointLabel())) {
                return point.getChain();
            }
        }
        Chain chain = new Chain();
//        chain.setAttributeList(new ArrayList<>());
        return chain;
    }

}
