package com.paper.ssm.test;

import com.paper.ssm.task.Message;
import com.paper.ssm.task.influx.InfluxImpl;
import com.paper.ssm.task.influx.ValueImpl;
import com.paper.ssm.task.influx.ValueService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.BeanWrapperImpl;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ZengYuan
 */
public class InfluxTest {

    private InfluxImpl influxConnect;
    private String username = "admin";
    private String password = "admin";
    private String url = "http://39.108.132.71:8086";
    private String database = "collection";
    private String measurement = "property";

    @Resource
    private ValueService valueService;

    @Before
    public void setUp(){
        //创建 连接
        influxConnect = new InfluxImpl(username, password, url, database);
        influxConnect.connect();
    }

    @Test
    public void testInsert(){//测试数据插入
        Map<String, String> tags = new HashMap<>();
        Map<String, Object> fields = new HashMap<>();
        List<Message> messageList = new ArrayList<>();

        Message message = new Message();
        message.setId(1L);
        message.setDeviceId(1);
        message.setMessageType(Message.MESSAGE_ATTRIBUTE);

        this.valueService = new ValueImpl();
        this.valueService.insert(message);
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
    private List<Message> getQueryData(List<String> columns, List<List<Object>>  values){

        List<Message> lists = new ArrayList<>();
        for (List<Object> list : values) {
            Message info = new Message();
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
