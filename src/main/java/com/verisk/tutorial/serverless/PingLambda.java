package com.verisk.tutorial.serverless;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.amazonaws.serverless.exceptions.ContainerInitializationException;
import com.amazonaws.serverless.proxy.model.AwsProxyRequest;
import com.amazonaws.serverless.proxy.model.AwsProxyResponse;
import com.amazonaws.serverless.proxy.spring.SpringBootLambdaContainerHandler;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;

public class PingLambda implements RequestStreamHandler {
	
	private static SpringBootLambdaContainerHandler<AwsProxyRequest, AwsProxyResponse> handler;
	
	static {
        try {
            handler = SpringBootLambdaContainerHandler.getAwsProxyHandler(PingApp.class);
        } catch (ContainerInitializationException e) {
            // if we fail here. We re-throw the exception to force another cold start
            e.printStackTrace();
            throw new RuntimeException("Could not initialize Spring Boot application", e);
        }
    }
	
	public void handleRequest(InputStream input, OutputStream output, Context context) throws IOException {
		handler.proxyStream(input, output, context);
	}

}
