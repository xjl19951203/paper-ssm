package com.paper.ssm.run.influx;

import com.paper.ssm.core.model.normalize.Attribute;
import com.paper.ssm.core.model.data.Data;
import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.BatchPoints;
import org.influxdb.dto.Point;
import org.influxdb.dto.Query;
import org.influxdb.dto.QueryResult;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author ZengYuan
 */
@Service("influxService")
public class InfluxImpl implements InfluxService {

    private InfluxDB influxdb;
    private BatchPoints batchPoints;
    private static String url = "http://39.108.132.71:8086";
    private static String database = "collection";

    public InfluxImpl() {
        this.influxdb = InfluxDBFactory.connect(url);
        this.influxdb.setDatabase(database)
                .setRetentionPolicy("default")
                .enableBatch(20,200, TimeUnit.MILLISECONDS);

        this.batchPoints = BatchPoints.database(database)
                .retentionPolicy("default")
                .build();

        /**
         * 设置数据保存策略
         * default 策略名 /database 数据库名/ 30d 数据保存时限30天/ 1  副本个数为1/ 结尾DEFAULT 表示 设为默认的策略
         */
        String command = String.format("CREATE RETENTION POLICY \"%s\" ON \"%s\" DURATION %s REPLICATION %s DEFAULT",
                "default", database, "30d", 2);
        influxdb.query(new Query(command, database));
    }

    @Override
    public QueryResult select(com.paper.ssm.core.model.data.Query query) {

        if (query.getMeasurement() == null) {
            query.setMeasurement("data");
        }
        if (query.getPointId() == null) {
            query.setPointId(1);
        }


        if (query.getPageSize() == null) {
            query.setPageSize(10);
        }
        if (query.getPageNum() == null) {
            query.setPageNum(1);
        }

        /** InfluxDB支持分页查询,因此可以设置分页查询条件 */
        String pageQuery = " LIMIT " + query.getPageSize() +
                " OFFSET " + ((query.getPageNum() - 1) * query.getPageSize());
        /** 此处查询所有内容,如果 */
        String queryCmd = "SELECT * FROM " +
                // 查询指定设备下的日志信息
                // 要指定从 RetentionPolicyName(保存策略前缀+设备ID).measurement(logInfo) 中查询指定数据)
                query.getMeasurement()
                // 查询结果需要按照时间排序
                + " ORDER BY time DESC"
                // 添加分页查询条件
                + pageQuery;
        return influxdb.query(new Query(queryCmd, database));
    }

    @Override
    public long insert(Data record) {

        Point.Builder builder = Point.measurementByPOJO(record.getClass())
                .addFieldsFromPOJO(record);

        for (Attribute field : record.getFieldList()) {
            builder.addField(field.getRule().getValue(), field.getValue());
        }


        Point point = builder.build();

        batchPoints.point(point);
        // 出于业务考量,设备可以设置不同的保存策略(策略名为固定前缀+设备ID)
        this.influxdb.write(batchPoints);
        return 0;
    }

    @Override
    public int insert(List<Data> records) {
        for (Data record : records) {
            Point point = Point.measurementByPOJO(record.getClass())
                    .addFieldsFromPOJO(record)
                    .build();
            batchPoints.point(point);
        }
        this.influxdb.write(batchPoints);
        return 0;
    }
}
