package com.paper.ssm.task.influx;

import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.Point;
import org.influxdb.dto.Point.Builder;
import org.influxdb.dto.Query;
import org.influxdb.dto.QueryResult;

import java.util.Map;

/**
 * 时序数据库 InfluxDB 连接
 * @author Dai_LW
 *
 */
public class InfluxConnect {

    private String username;
    private String password;
    private String url;
    private String database;

    private static InfluxDB influxDB;


    public InfluxConnect(String username, String password, String url, String database){
        this.username = username;
        this.password = password;
        this.url = url;
        this.database = database;
    }

    /**连接时序数据库；获得InfluxDB**/
    public InfluxDB  influxDbBuild(){
        if(influxDB == null){
            influxDB = InfluxDBFactory.connect(url, username, password);
            influxDB.createDatabase(database);
        }
        return influxDB;
    }

    /**
     * 设置数据保存策略
     * default 策略名 /database 数据库名/ 30d 数据保存时限30天/ 1  副本个数为1/ 结尾DEFAULT 表示 设为默认的策略
     */
    public void createRetentionPolicy(){
        String command = String.format("CREATE RETENTION POLICY \"%s\" ON \"%s\" DURATION %s REPLICATION %s DEFAULT",
                "default", database, "30d", 1);
        this.query(command);
    }

    /**
     * 查询
     * @param command 查询语句
     * @return QueryResult
     */
    public QueryResult query(String command){
        return influxDB.query(new Query(command, database));
    }

    /**
     * 插入
     * @param measurement 表
     * @param tags 标签
     * @param fields 字段
     */
    public void insert(String measurement, Map<String, String> tags, Map<String, Object> fields){
        Builder builder = Point.measurement(measurement);
        builder.tag(tags);
        builder.fields(fields);

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

    /**
     * 创建数据库
     * @param dbName 数据库名称
     */
    public void createDB(String dbName){
        influxDB.createDatabase(dbName);
    }

    /**
     * 删除数据库
     * @param dbName 数据库名称
     */
    public void deleteDB(String dbName){
        influxDB.deleteDatabase(dbName);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setDatabase(String database) {
        this.database = database;
    }
}
