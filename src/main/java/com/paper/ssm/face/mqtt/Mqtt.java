package com.paper.ssm.face.mqtt;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

/**
 * @author ZengYuan
 */
public class Mqtt {

    private String username = "admin";
    private String password = "admin";
    private MqttConnectOptions options;
    private String broker = "tcp://39.108.132.71:1883";
    private String clientId = "client_server_1";
    private MqttClient client;
    private String topic = "/topic/#";

    public Mqtt() {
        try {
            MemoryPersistence persistence = new MemoryPersistence();
            client = new MqttClient(broker, clientId, persistence);
            options = new MqttConnectOptions();
            // 设置回调
            client.setCallback(new MqttCallback());
            // MqttTopic topic = client.getTopic(TOPIC1);
            //setWill方法，如果项目中需要知道客户端是否掉线可以调用该方法。设置最终端口的通知消息
            //遗嘱 options.setWill(topic, "close".getBytes(), 2, true);
            // 设置是否清空session,这里如果设置为false表示服务器会保留客户端的连接记录，
            // 设置为true表示每次连接到服务器都以新的身份连接
            options.setCleanSession(false);
            // 设置连接的用户名
            options.setUserName(username);
            // 设置连接的密码
            options.setPassword(password.toCharArray());
            // 设置超时时间 单位为秒
            options.setConnectionTimeout(5);
            // 设置会话心跳时间 单位为秒 服务器会每隔1.5*20秒的时间向客户端发送个消息判断客户端是否在线，
            // 但这个方法并没有重连的机制
            options.setKeepAliveInterval(20);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {
        connect();
        subscribe(topic);
    }

    public void connect() {
        try {
            client.connect(options);
            System.out.println("Mqtt: " + clientId + " Connect " + broker + " Success...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void subscribe(String topic) {
        try {
            client.subscribe(topic);
        } catch (MqttException me) {
            me.printStackTrace();
        }
    }

}
