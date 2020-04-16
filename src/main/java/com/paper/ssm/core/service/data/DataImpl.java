package com.paper.ssm.core.service.data;

import com.paper.ssm.core.model.data.Data;
import com.paper.ssm.core.model.data.Query;
import com.paper.ssm.core.model.integration.Process;
import com.paper.ssm.core.model.normalize.Chain;
import com.paper.ssm.core.model.structure.Point;
import com.paper.ssm.core.service.integration.ProcessService;
import com.paper.ssm.run.drools.DroolsService;
import com.paper.ssm.run.influx.InfluxService;
import org.influxdb.dto.QueryResult;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


/**
 * @author ZengYuan
 */
@Service("dataService")
public class DataImpl implements DataService {

    @Resource
    ProcessService processService;
    @Resource
    DroolsService droolsService;
    @Resource
    InfluxService influxService;

    @Override
    public Data insert(Data data) {
//        Chain chain = getChain(data);
//        this.droolsService.run(data, chain);
        this.influxService.insert(data);
        return data;
    }

    @Override
    public int insert(List<Data> records) {
        return 0;
    }

    @Override
    public int delete(Data record) {
        return 0;
    }

    @Override
    public Data update(Data record) {
        return null;
    }

    @Override
    public List<Data> selectListByQuery(Data data) {
        QueryResult results = this.influxService.select(data);
        if(results.getResults() == null){
            return null;
        }
        List<Data> lists = new ArrayList<>();
        for (QueryResult.Result result : results.getResults()) {

            List<QueryResult.Series> seriesList = result.getSeries();
            for (QueryResult.Series series : seriesList) {
//				Map<String, String> tags = series.getTags();
                List<List<Object>>  values = series.getValues();
                List<String> columns = series.getColumns();

                lists.addAll(getQueryData(columns, values));
            }
        }
        return lists;
    }

    @Override
    public Integer selectCountByQuery(Data query) {
        return null;
    }

    @Override
    public Data selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public Data selectSimpleByPrimaryKey(Integer id) {
        return null;
    }

    private Chain getChain(Data data) {
        System.out.println(data.getProcessId());
        Process process = this.processService.selectByPrimaryKey(data.getProcessId());
        for (Point point : process.getNode().getPointList()) {
//            if (point.getId().equals(data.getPointId()) &&
//                    point.getLabel().equals(data.getPointLabel())) {
//                return point.getChain();
//            }
        }
        Chain chain = new Chain();
//        chain.setAttributeList(new ArrayList<>());
        return chain;
    }

    /***整理列名、行数据***/
    private List<Data> getQueryData(List<String> columns, List<List<Object>>  values){
        List<Data> lists = new ArrayList<>();

        for (List<Object> list : values) {
            Data info = new Data();
            BeanWrapperImpl bean = new BeanWrapperImpl(info);
            for(int i=0; i< list.size(); i++){
                /** 字段名 */
                String propertyName = setColumns(columns.get(i));
                /** 相应字段值 */
                Object value = list.get(i);
                bean.setPropertyValue(propertyName, value);
            }

            lists.add(info);
        }

        return lists;
    }

    /***转义字段***/
    private String setColumns(String column){
        String[] cols = column.split("_");
        StringBuffer sb = new StringBuffer();
        for(int i=0; i< cols.length; i++){
//            String col = cols[i].toLowerCase();
            String col = cols[i];
            if(i != 0){
                String start = col.substring(0, 1).toUpperCase();
                String end = col.substring(1).toLowerCase();
                col = start + end;
            }
            sb.append(col);
        }
        return sb.toString();
    }
}
