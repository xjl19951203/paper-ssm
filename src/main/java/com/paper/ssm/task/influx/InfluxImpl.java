package com.paper.ssm.task.influx;

import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.Point;
import org.influxdb.dto.Point.Builder;
import org.influxdb.dto.Query;
import org.influxdb.dto.QueryResult;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 时序数据库 InfluxDB 连接
 * @author Dai_LW
 *
 */
@Service("influxService")
public class InfluxImpl implements InfluxService{

    private String username;
    private String password;
    private String url;
    private String database;
    private static InfluxDB influxDB;

    public InfluxImpl(String username, String password, String url, String database){
        this.username = username;
        this.password = password;
        this.url = url;
        this.database = database;
    }

    /**连接时序数据库；获得InfluxDB**/
    @Override
    public InfluxDB connect(){
        if(influxDB == null){
            influxDB = InfluxDBFactory.connect(url, username, password);
            influxDB.createDatabase(database);
        }
        this.createRetentionPolicy();
        return influxDB;
    }

    /**
     * 设置数据保存策略
     * default 策略名 /database 数据库名/ 30d 数据保存时限30天/ 1  副本个数为1/ 结尾DEFAULT 表示 设为默认的策略
     */
    private void createRetentionPolicy(){
        String command = String.format("CREATE RETENTION POLICY \"%s\" ON \"%s\" DURATION %s REPLICATION %s DEFAULT",
                "default", database, "30d", 1);
        this.selectByQuery(command);
    }

    /**
     * 查询
     * @param command 查询语句
     * @return QueryResult
     */
    @Override
    public QueryResult selectByQuery(String command){
        return influxDB.query(new Query(command, database));
    }


    @Override
    public void insert(Record record){
        Builder builder = Point.measurement(record.getMeasurement());
        builder.tag(record.getTags());
        builder.fields(record.getFields());
        influxDB.write(database, "", builder.build());
    }

    /**
     * 删除
     * @param command 删除语句
     * @return 返回错误信息
     */
    public String deleteMeasurementData(String command){
        QueryResult result = influxDB.query(new Query(command, database));
        return result.getError();
    }


}
