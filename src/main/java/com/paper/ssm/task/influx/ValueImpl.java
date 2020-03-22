package com.paper.ssm.task.influx;

import com.paper.ssm.task.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * @author ZengYuan
 */
@Service("valueService")
public class ValueImpl implements ValueService {

    @Resource
    InfluxService influxService;

    @Override
    public long insert(Value record) {
        /**
         *
         * 在influx插入之前，执行规则引擎，可以用AOP
         */
        this.influxService.insert(record);
        return 0;
    }

    @Override
    public int insert(List<Value> records) {
        return 0;
    }
}
