package com.training.rest.client;

import jakarta.websocket.ClientEndpoint;
import jakarta.websocket.EndpointConfig;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;

@ClientEndpoint
public class WebServerClient {


    @OnOpen
    public void onOpen(final Session session,
                       final EndpointConfig endpointConfig) {
        System.out.println("Client connection established");
    }


    @OnMessage
    public void onMessage(final String message) {
        System.out.println("Message from server : " + message);
    }


}
