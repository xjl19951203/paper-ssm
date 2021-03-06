package com.paper.ssm.face.mqtt;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.paper.ssm.core.model.data.Data;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * 发布消息的回调类
 *
 * 必须实现MqttCallback的接口并实现对应的相关接口方法CallBack 类将实现 MqttCallBack。
 * 每个客户机标识都需要一个回调实例。在此示例中，构造函数传递客户机标识以另存为实例数据。
 * 在回调中，将它用来标识已经启动了该回调的哪个实例。
 * 必须在回调类中实现三个方法：
 *
 *  public void messageArrived(MqttTopic topic, MqttMessage message)接收已经预订的发布。
 *
 *  public void connectionLost(Throwable cause)在断开连接时调用。
 *
 *  public void deliveryComplete(MqttDeliveryToken token))
 *  接收到已经发布的 QoS 1 或 QoS 2 消息的传递令牌时调用。
 *  由 MqttClient.connect 激活此回调。
 *
 * @author ZengYuan
 */
@Component
public class MqttCallback implements org.eclipse.paho.client.mqttv3.MqttCallback {

    @Resource
    TaskService taskService;

    private MqttCallback mqttCallback;

    @PostConstruct
    public void init() {
        mqttCallback = this;
        mqttCallback.taskService = this.taskService;
    }

    @Override
    public void connectionLost(Throwable cause) {
        // 连接丢失后，一般在这里面进行重连
        System.out.println("连接断开，可以做重连");
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {
//        System.out.println("deliveryComplete---------" + token.isComplete());
    }

    @Override
    public void messageArrived(String topic, MqttMessage message) {
        // subscribe后得到的消息会执行到这里面
//        System.out.println(topic);
        /** 作为服务器客户端，由于需要对所有数据都加以存储，因此订阅的topic是最泛的 */
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Data data = objectMapper.readValue(new String(message.getPayload()), Data.class);
            this.taskService.run(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}