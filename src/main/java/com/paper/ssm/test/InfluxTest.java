package com.paper.ssm.test;

import com.paper.ssm.SsmApplication;
import com.paper.ssm.core.model.data.Data;
import com.paper.ssm.core.model.data.Query;
import com.paper.ssm.run.influx.DataService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Random;

/**
 * @author ZengYuan
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SsmApplication.class)
public class InfluxTest {

    @Resource
    private DataService dataService;

    @Before
    public void setup() {
    }

    @Test
    public void testInsert(){//测试数据插入
        int loop = 100;
        Random random = new Random();
        for (int i = 0; i < loop; i++) {
            Data data = new Data();
            data.setPointId(i);
            data.setInstanceId(1);
            data.setValue(String.valueOf(random.nextInt(62)));
            this.dataService.insert(data);
        }
    }

    @Test
    public void testQuery(){
        Query query = new Query();
        query.setMeasurement("data");
        query.setPageNum(10);
        query.setPageSize(5);
        query.setPointId(1);
        this.dataService.select(query);
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

}
