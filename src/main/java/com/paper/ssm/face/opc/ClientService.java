package com.paper.ssm.face.opc;

import org.eclipse.milo.opcua.sdk.client.OpcUaClient;
import org.eclipse.milo.opcua.sdk.client.api.identity.AnonymousProvider;
import org.eclipse.milo.opcua.sdk.client.api.identity.IdentityProvider;
import org.eclipse.milo.opcua.stack.core.security.SecurityPolicy;
import org.eclipse.milo.opcua.stack.core.types.structured.EndpointDescription;

import java.util.concurrent.CompletableFuture;
import java.util.function.Predicate;

/**
 * @className: ClientService
 * @author: ZengYuan
 * @description:
 * @date 2020/4/2 20:17
 * @version: 1.0
 */
public interface ClientService {

    /**
     * 获取endPoint
     * @return url
     */
    default String getEndpointUrl() {
        return "opc.tcp://localhost:12686/milo";
    }

    /**
     * endpointFilter
     * @return endpointFilter
     */
    default Predicate<EndpointDescription> endpointFilter() {
        return e -> true;
    }

    /**
     * getSecurityPolicy
     * @return getSecurityPolicy
     */
    default SecurityPolicy getSecurityPolicy() {
        return SecurityPolicy.None;
    }

    /**
     * getIdentityProvider
     * @return getIdentityProvider
     */
    default IdentityProvider getIdentityProvider() {
        return new AnonymousProvider();
    }

    /**
     * run
     * @param client client
     * @param future future
     * @throws Exception exception
     */
    void run(OpcUaClient client, CompletableFuture<OpcUaClient> future) throws Exception;
}
