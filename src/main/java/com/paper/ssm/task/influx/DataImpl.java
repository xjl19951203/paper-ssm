package com.paper.ssm.task.influx;

import com.paper.ssm.task.Data;
import com.paper.ssm.task.Query;
import org.influxdb.dto.QueryResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


/**
 * @author ZengYuan
 */
@Service("valueService")
public class DataImpl implements DataService {

    @Resource
    InfluxService influxService;

    @Override
    public QueryResult select(Query query) {

        if (query.getMeasurement() == null) {
            query.setMeasurement("data");
        }
        if (query.getPointId() == null) {
            query.setPointId(1);
        }

        QueryResult results = this.influxService.select(query);
        return results;
//        if(results.getResults() == null){
//            return null;
//        }
//        List<Value> valueList = new ArrayList<>();
//        for (QueryResult.Result result : results.getResults()) {
//
//            List<QueryResult.Series> seriesList = result.getSeries();
//            for (QueryResult.Series series : seriesList) {
//                List<List<Object>>  values = series.getValues();
//                List<String> columns = series.getColumns();
//
//                valueList.addAll(getQueryData(columns, values));
//            }
//        }
//        return valueList;
    }

    @Override
    public long insert(Data record) {
        /**
         *
         * 在influx插入之前，执行规则引擎，可以用AOP
         */
        this.influxService.insert(record);
        return 0;
    }

    @Override
    public int insert(List<Data> records) {
        return 0;
    }

    /***整理列名、行数据***/
    private List<Data> getQueryData(List<String> columns, List<List<Object>>  values){

        List<Data> lists = new ArrayList<>();
//        for (List<Object> list : values) {
//            Value info = Value.builder().build();
//            BeanWrapperImpl bean = new BeanWrapperImpl(info);
//            for(int i=0; i< list.size(); i++){
//                /** 字段名 */
//                String propertyName = setColumns(columns.get(i));
//                /** 相应字段值 */
//                Object value = list.get(i);
//                bean.setPropertyValue(propertyName, value);
//            }
//
//            lists.add(info);
//        }
        return lists;
    }
    /***转义字段***/
    private String setColumns(String column){
        String[] cols = column.split("_");
        StringBuilder sb = new StringBuilder();
        for(int i=0; i< cols.length; i++){
            String col = cols[i].toLowerCase();
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
