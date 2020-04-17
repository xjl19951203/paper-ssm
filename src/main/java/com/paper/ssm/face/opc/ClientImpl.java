package com.paper.ssm.face.opc;

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

    public void runs(OpcUaClient client, CompletableFuture<OpcUaClient> future) throws Exception {
        // synchronous connect
        client.connect().get();

        // synchronous read request via VariableNode
        VariableNode node = client.getAddressSpace().createVariableNode(
                new NodeId(5, "主轴转速"));

        logger.info("DataType={}", node.getDataType().get());

        // Read the current value
        DataValue value = node.readValue().get();
        logger.info("Value={}", value);

        Variant variant = value.getValue();
        logger.info("Variant={}", variant);

        String res = String.valueOf(variant.getValue());

        logger.info("Decoded={}", res);

        future.complete(client);
    }

    @Override
    public void run(OpcUaClient client, CompletableFuture<OpcUaClient> future) throws Exception {

        //创建连接
        client.connect().get();

        //创建发布间隔1000ms的订阅对象
        UaSubscription subscription = client.getSubscriptionManager().createSubscription(1000.0).get();

        //创建订阅的变量
        NodeId nodeId = new NodeId(5,"主轴转速");
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
        List<UaMonitoredItem> items = subscription.createMonitoredItems(
                TimestampsToReturn.Both,
                requests,
                (item,id)->{
                    item.setValueConsumer((subItem, value)->{
                        System.out.println("nodeid :"+subItem.getReadValueId().getNodeId());
                        System.out.println("value :"+value.getValue().getValue());
                    });
                }
        ).get();

    }

    private void onSubscriptionValue(UaMonitoredItem item, DataValue value) {
        logger.info(
                "subscription value received: item={}, value={}",
                item.getReadValueId().getNodeId(), value.getValue());
    }
}
