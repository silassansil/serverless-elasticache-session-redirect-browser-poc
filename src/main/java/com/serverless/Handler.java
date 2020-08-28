package com.serverless;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;
import java.util.UUID;

import static java.util.Collections.singletonMap;

public class Handler implements RequestHandler<Map<String, Object>, ApiGatewayResponse> {

    private static final Logger LOG = LogManager.getLogger(Handler.class);
    public static final String REDIS_HOST = System.getenv("REDIS_HOST");

    @Override
    public ApiGatewayResponse handleRequest(Map<String, Object> input, Context context) {
        LOG.info("received: {}", input);
        return ApiGatewayResponse.builder()
                .setStatusCode(301)
                .setHeaders(singletonMap("Location", "http://www.google.com?sessionId=" + UUID.randomUUID()))
                .build();
    }
}
