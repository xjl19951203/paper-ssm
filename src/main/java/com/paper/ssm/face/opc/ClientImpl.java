package com.paper.ssm.face.opc;

import org.eclipse.milo.opcua.sdk.client.OpcUaClient;
import org.eclipse.milo.opcua.sdk.client.api.nodes.VariableNode;
import org.eclipse.milo.opcua.stack.core.types.OpcUaDefaultBinaryEncoding;
import org.eclipse.milo.opcua.stack.core.types.builtin.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

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
        registerCustomCodec(client);

        // synchronous connect
        client.connect().get();

        // synchronous read request via VariableNode
        VariableNode node = client.getAddressSpace().createVariableNode(
                new NodeId(2, "HelloWorld/CustomDataTypeVariable"));

        logger.info("DataType={}", node.getDataType().get());

        // Read the current value
        DataValue value = node.readValue().get();
        logger.info("Value={}", value);

        Variant variant = value.getValue();
        ExtensionObject xo = (ExtensionObject) variant.getValue();

        DataType decoded = (DataType) xo.decode(
                client.getSerializationContext()
        );
        logger.info("Decoded={}", decoded);

        // Write a modified value
        DataType modified = new DataType(
                decoded.getFoo() + "bar",
                uint(decoded.getBar().intValue() + 1),
                !decoded.isBaz()
        );
        ExtensionObject modifiedXo = ExtensionObject.encode(
                client.getSerializationContext(),
                modified,
                xo.getEncodingId(),
                OpcUaDefaultBinaryEncoding.getInstance()
        );

        StatusCode writeStatus = node.writeValue(new DataValue(new Variant(modifiedXo))).get();

        logger.info("writeStatus={}", writeStatus);

        // Read the modified value back
        value = node.readValue().get();
        logger.info("Value={}", value);

        variant = value.getValue();
        xo = (ExtensionObject) variant.getValue();

        decoded = (DataType) xo.decode(
                client.getSerializationContext()
        );
        logger.info("Decoded={}", decoded);

        future.complete(client);
    }

    private void registerCustomCodec(OpcUaClient client) {
        NodeId binaryEncodingId = new NodeId(2, "DataType.CustomDataType.BinaryEncoding");

        // Register codec with the client DataTypeManager instance
        client.getDataTypeManager().registerCodec(
                binaryEncodingId,
                new DataType.Codec().asBinaryCodec()
        );
    }
}
