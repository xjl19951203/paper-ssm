package com.paper.ssm.core.service.data;

import com.paper.ssm.core.model.data.Data;
import com.paper.ssm.core.service.Service;
import org.influxdb.dto.QueryResult;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ZengYuan
 */
@Resource
public interface DataService extends Service<Data> {

    QueryResult selectResultByQuery(Data query);
}
