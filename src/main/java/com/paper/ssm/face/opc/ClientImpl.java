package com.paper.ssm.face.opc;

import com.paper.ssm.SpringContextHolder;
import com.paper.ssm.core.model.data.Data;
import com.paper.ssm.face.mqtt.Mqtt;
import org.eclipse.milo.opcua.sdk.client.OpcUaClient;
import org.eclipse.milo.opcua.sdk.client.api.nodes.VariableNode;
import org.eclipse.milo.opcua.sdk.client.api.subscriptions.UaMonitoredItem;
import org.eclipse.milo.opcua.sdk.client.api.subscriptions.UaSubscription;
import org.eclipse.milo.opcua.stack.core.AttributeId;
import org.eclipse.milo.opcua.stack.core.Identifiers;
import org.eclipse.milo.opcua.stack.core.types.OpcUaDefaultBinaryEncoding;
import org.eclipse.milo.opcua.stack.core.types.builtin.*;
import org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.UInteger;
import org.eclipse.milo.opcua.stack.core.types.enumerated.MonitoringMode;
import org.eclipse.milo.opcua.stack.core.types.enumerated.TimestampsToReturn;
import org.eclipse.milo.opcua.stack.core.types.structured.MonitoredItemCreateRequest;
import org.eclipse.milo.opcua.stack.core.types.structured.MonitoringParameters;
import org.eclipse.milo.opcua.stack.core.types.structured.ReadValueId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

import static org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.Unsigned.uint;

/**
 * @className: Client
 * @author: ZengYuan
 * @description:
 * @date 2020/4/2 20:15
 * @version: 1.0
 */
@Service("clientService")
public class ClientImpl implements ClientService{

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void run(OpcUaClient client, CompletableFuture<OpcUaClient> future) throws Exception {

        //创建连接
        client.connect().get();

        //创建发布间隔1000ms的订阅对象
        UaSubscription subscription = client.getSubscriptionManager().createSubscription(1000.0).get();

        //创建订阅的变量
        NodeId nodeId = new NodeId(5,"123");
        ReadValueId readValueId = new ReadValueId(nodeId,AttributeId.Value.uid(),null,null);

        //创建监控的参数
        MonitoringParameters parameters = new MonitoringParameters(
                uint(1),
                // sampling interval
                1000.0,
                // filter, null means use default
                null,
                // queue size
                uint(10),
                // discard oldest
                true
        );

        //创建监控项请求
        //该请求最后用于创建订阅。
        MonitoredItemCreateRequest request = new MonitoredItemCreateRequest(readValueId, MonitoringMode.Reporting, parameters);

        List<MonitoredItemCreateRequest> requests = new ArrayList<>();
        requests.add(request);

        //创建监控项，并且注册变量值改变时候的回调函数。
        subscription.createMonitoredItems(
                TimestampsToReturn.Both,
                requests,
                (item, id) -> item.setValueConsumer((subItem, value) -> {
                    System.out.println("nodeId :"+subItem.getReadValueId().getNodeId());
                    System.out.println("value :"+value.getValue().getValue());
                    publish(subItem.getReadValueId().getNodeId(), value.getValue());
                })
        ).get();

    }

    private void publish(NodeId nodeId, Variant variant) {
        Mqtt mqtt = SpringContextHolder.getBean("mqtt");
        Data data = new Data();
        System.out.println(nodeId.getIdentifier());
        data.setAttributeId(Integer.valueOf(nodeId.getIdentifier().toString()));
        data.setValue(variant.getValue().toString());
        mqtt.publish(data);
    }

}
