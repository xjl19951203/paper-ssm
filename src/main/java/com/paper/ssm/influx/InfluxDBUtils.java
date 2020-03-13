package com.paper.ssm.influx;

import lombok.Data;
import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Data
public class InfluxDBUtils {

    private String userName;
    private String password;
    private String url;

    private String database;
    private String retentionPolicy;

    public InfluxDB getInfluxDB() {
        return influxDB;
    }

    public void setInfluxDB(InfluxDB influxDB) {
        this.influxDB = influxDB;
    }

    // InfluxDB实例
    private InfluxDB influxDB;

    Logger logger = LoggerFactory.getLogger(InfluxDBUtils.class);

    // 数据保存策略
    public static String policyNamePix = "logmonitor";

    public InfluxDBUtils(String userName, String password, String url, String database,
                         String retentionPolicy) {
        this.userName = userName;
        this.password = password;
        this.url = url;
        this.database = database;
        this.retentionPolicy = retentionPolicy == null || "".equals(retentionPolicy) ? "autogen" : retentionPolicy;
        this.influxDB = influxDbBuild();
    }

    /**
     * 连接数据库 ，若不存在则创建
     *
     * @return influxDb实例
     */
    private InfluxDB influxDbBuild() {
        if (influxDB == null) {
            influxDB = InfluxDBFactory.connect(url, userName, password);
        }
        try {
            createDB(database);
            influxDB.setDatabase(database);
        } catch (Exception e) {
            logger.error("create influx db failed, error: {}", e.getMessage());
        } finally {
            influxDB.setRetentionPolicy(retentionPolicy);
        }
        influxDB.setLogLevel(InfluxDB.LogLevel.BASIC);
        return influxDB;
    }

    /****
     *  创建数据库
     * @param database
     */
    private void createDB(String database) {
        influxDB.query(new Query("CREATE DATABASE " + database));
    }


    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

}

