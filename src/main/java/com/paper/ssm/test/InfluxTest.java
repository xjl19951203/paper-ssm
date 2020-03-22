package com.paper.ssm.test;

import com.paper.ssm.SsmApplication;
import com.paper.ssm.task.Value;
import com.paper.ssm.task.influx.ValueService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ZengYuan
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SsmApplication.class)
public class InfluxTest {

    @Resource
    private ValueService valueService;

    @Before
    public void setup() {
    }

    @Test
    public void testInsert(){//测试数据插入

        Value value = new Value();
        value.setId(1L);
        value.setPointId(1);
        this.valueService.insert(value);
    }

    @Test
    public void testQuery(){//测试数据查询
//        String command = "select * from " + this.measurement;
//        QueryResult results = influxDB.query(command);
//
//        if(results.getResults() == null){
//            return;
//        }
//        List<Message> lists = new ArrayList<>();
//        for (Result result : results.getResults()) {
//
//            List<Series> seriesList = result.getSeries();
//            for (Series series : seriesList) {
////				Map<String, String> tags = series.getTags();
//                List<List<Object>>  values = series.getValues();
//                List<String> columns = series.getColumns();
//
//                lists.addAll(getQueryData(columns, values));
//            }
//        }
//
//        Assert.assertTrue((!lists.isEmpty()));
//        Assert.assertEquals(2, lists.size());
    }

    @Test
    public void testQueryWhere(){//tag 列名 区分大小写
//        String command = "select * from " + this.measurement + " where TAG_CODE='ABC'";
//        QueryResult results = influxDB.query(command);
//
//        if(results.getResults() == null){
//            return;
//        }
//        List<Message> lists = new ArrayList<>();
//        for (Result result : results.getResults()) {
//
//            List<Series> seriesList= result.getSeries();
//            for (Series series : seriesList) {
//                List<List<Object>>  values = series.getValues();
//                List<String> columns = series.getColumns();
//
//                lists.addAll(getQueryData(columns, values));
//            }
//        }
//
//        Assert.assertTrue((!lists.isEmpty()));
//        Assert.assertEquals(1, lists.size());
//
//        Message info = lists.get(0);
//
//        Assert.assertEquals(info.getDeviceId(), "ABC");

    }

    @Test
    public void deleteMeasurementData(){
//        String command = "delete from " + this.measurement + " where TAG_CODE='ABC'";
//        String err = influxDB.deleteMeasurementData(command);
//        Assert.assertNull(err);
    }

    /***整理列名、行数据***/
    private List<Value> getQueryData(List<String> columns, List<List<Object>>  values){

        List<Value> lists = new ArrayList<>();
        for (List<Object> list : values) {
            Value info = new Value();
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
