package com.paper.ssm.face.opc;

import com.paper.ssm.SpringContext;
import com.paper.ssm.core.model.data.Data;
import com.paper.ssm.face.mqtt.Mqtt;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.eclipse.milo.opcua.sdk.client.OpcUaClient;
import org.eclipse.milo.opcua.sdk.client.api.config.OpcUaClientConfig;
import org.eclipse.milo.opcua.sdk.client.api.nodes.Node;
import org.eclipse.milo.opcua.sdk.client.api.subscriptions.UaSubscription;
import org.eclipse.milo.opcua.stack.client.DiscoveryClient;
import org.eclipse.milo.opcua.stack.core.AttributeId;
import org.eclipse.milo.opcua.stack.core.Identifiers;
import org.eclipse.milo.opcua.stack.core.security.SecurityPolicy;
import org.eclipse.milo.opcua.stack.core.types.builtin.*;
import org.eclipse.milo.opcua.stack.core.types.enumerated.MonitoringMode;
import org.eclipse.milo.opcua.stack.core.types.enumerated.TimestampsToReturn;
import org.eclipse.milo.opcua.stack.core.types.structured.EndpointDescription;
import org.eclipse.milo.opcua.stack.core.types.structured.MonitoredItemCreateRequest;
import org.eclipse.milo.opcua.stack.core.types.structured.MonitoringParameters;
import org.eclipse.milo.opcua.stack.core.types.structured.ReadValueId;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;

import static org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.Unsigned.uint;

/**
 * @className: Client
 * @author: ZengYuan
 * @description:
 * @date 2020/4/2 20:15
 * @version: 1.0
 */
@Service("clientService")
@Component
public class ClientImpl implements ClientService{

    static {
        // Required for SecurityPolicy.Aes256_Sha256_RsaPss
        Security.addProvider(new BouncyCastleProvider());
    }

    public ClientImpl() {
        try {
            OpcUaClient client = createClient();
            run(client);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run(OpcUaClient client) throws Exception {

        //创建连接
        client.connect().get();

//        List<Node> nodes = client.getAddressSpace().browse(Identifiers.RootFolder).get();
//
//        for(Node node:nodes){
//            System.out.println("Node= " + node.getBrowseName().get().getName());
//        }


        //创建发布间隔1000ms的订阅对象
        UaSubscription subscription = client.getSubscriptionManager().createSubscription(1000.0).get();

        //创建订阅的变量
        NodeId nodeId1 = new NodeId(5,"锯条速度");
        NodeId nodeId2 = new NodeId(5,"进给量");
        ReadValueId readValueId1 = new ReadValueId(nodeId1,AttributeId.Value.uid(),null,null);
        ReadValueId readValueId2 = new ReadValueId(nodeId2,AttributeId.Value.uid(),null,null);

        //创建监控的参数
        MonitoringParameters parameters1 = new MonitoringParameters(
                uint(1),
                // sampling interval
                3000.0,
                // filter, null means use default
                null,
                // queue size
                uint(10),
                // discard oldest
                true
        );
        //创建监控的参数
        MonitoringParameters parameters2 = new MonitoringParameters(
                uint(2),
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
        MonitoredItemCreateRequest request1 = new MonitoredItemCreateRequest(readValueId1, MonitoringMode.Reporting, parameters1);
        MonitoredItemCreateRequest request2 = new MonitoredItemCreateRequest(readValueId2, MonitoringMode.Reporting, parameters2);

        List<MonitoredItemCreateRequest> requests = new ArrayList<>();
        requests.add(request1);
        requests.add(request2);

        //创建监控项，并且注册变量值改变时候的回调函数。
        subscription.createMonitoredItems(
                TimestampsToReturn.Both,
                requests,
                (item, id) -> item.setValueConsumer((subItem, value) -> {
                    publish(subItem.getReadValueId().getNodeId(), value.getValue());
                })
        ).get();

    }

    private void publish(NodeId nodeId, Variant variant) {
        Mqtt mqtt = SpringContext.getBean("mqtt");
        Data data = new Data();
//        System.out.println(nodeId.getIdentifier());
        if (nodeId.getIdentifier().toString().equals("锯条速度")) {
            data.setAttributeId(42);
        } else {
            data.setAttributeId(3);
        }
        data.setProcessId(6);
        data.setPointId(24);
        data.setInformationId(8);

        data.setValue(variant.getValue().toString());
        mqtt.publish(data);
    }


    private OpcUaClient createClient() throws Exception {
        Path securityTempDir = Paths.get(System.getProperty("java.io.tmpdir"), "security");
        Files.createDirectories(securityTempDir);
        if (!Files.exists(securityTempDir)) {
            throw new Exception("unable to create security dir: " + securityTempDir);
        }
        LoggerFactory.getLogger(getClass())
                .info("security temp dir: {}", securityTempDir.toAbsolutePath());

        KeyStoreLoader loader = new KeyStoreLoader().load(securityTempDir);

        SecurityPolicy securityPolicy = this.getSecurityPolicy();

        List<EndpointDescription> endpoints;

        try {
            endpoints = DiscoveryClient.getEndpoints(this.getEndpointUrl()).get();
        } catch (Throwable ex) {
            // try the explicit discovery endpoint as well
            String discoveryUrl = this.getEndpointUrl();

            if (!discoveryUrl.endsWith("/")) {
                discoveryUrl += "/";
            }
            discoveryUrl += "discovery";

            endpoints = DiscoveryClient.getEndpoints(discoveryUrl).get();
        }

        EndpointDescription endpoint = endpoints.stream()
                .filter(e -> e.getSecurityPolicyUri().equals(securityPolicy.getUri()))
                .filter(this.endpointFilter())
                .findFirst()
                .orElseThrow(() -> new Exception("no desired endpoints returned"));

        OpcUaClientConfig config = OpcUaClientConfig.builder()
                .setApplicationName(LocalizedText.english("eclipse milo opc-ua client"))
                .setApplicationUri("urn:eclipse:milo:examples:client")
                .setCertificate(loader.getClientCertificate())
                .setKeyPair(loader.getClientKeyPair())
                .setEndpoint(endpoint)
                .setIdentityProvider(this.getIdentityProvider())
                .setRequestTimeout(uint(5000))
                .build();

        return OpcUaClient.create(config);
    }

}
