package com.paper.ssm.task.influx;

import com.paper.ssm.task.Value;
import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.BatchPoints;
import org.influxdb.dto.Point;
import org.influxdb.dto.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author ZengYuan
 */
@Service("influxService")
public class InfluxImpl implements InfluxService {

    private InfluxDB influxDB;
    private BatchPoints batchPoints;

    public InfluxImpl() {
        String url = "http://39.108.132.71:8086";
        String database = "collection";
        this.influxDB = InfluxDBFactory.connect(url);
        this.influxDB.setDatabase(database)
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
        influxDB.query(new Query(command, database));
    }

    @Override
    public long insert(Value record) {

        Point point = Point.measurementByPOJO(record.getClass()).
                tag("pointId", record.getPointId().toString()).build();

        batchPoints.point(point);
        // 出于业务考量,设备可以设置不同的保存策略(策略名为固定前缀+设备ID)
        this.influxDB.write(batchPoints);
        return 0;
    }

    @Override
    public int insert(List<Value> records) {
        return 0;
    }
}
