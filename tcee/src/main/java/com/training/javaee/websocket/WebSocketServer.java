package com.training.javaee.websocket;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.websocket.CloseReason;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/websocket/tryout")
public class WebSocketServer {

    private final Map<String, Session> sessionMap = new ConcurrentHashMap<>();


    public WebSocketServer() {
        Mythread mythreadLoc = new Mythread(this.sessionMap);
        mythreadLoc.start();
    }

    public static class Mythread extends Thread {

        Map<String, Session> sessionMap;

        public Mythread(final Map<String, Session> sessionMapParam) {
            super();
            this.sessionMap = sessionMapParam;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(2_000);
                    Collection<Session> valuesLoc = this.sessionMap.values();
                    for (Session sessionLoc : valuesLoc) {
                        try {
                            sessionLoc.getBasicRemote()
                                      .sendText("Hello from server");
                        } catch (Exception eLoc) {
                        }
                    }
                } catch (Exception eLoc) {
                }
            }
        }
    }

    @OnOpen
    public void onOpen(final Session session,
                       final EndpointConfig endpointConfig) {
        String idLoc = session.getId();
        System.out.println("Connection opened with id : " + idLoc);
        this.sessionMap.put(idLoc,
                            session);
    }


    @OnClose
    public void onClose(final Session session,
                        final CloseReason closeReason) {
        String idLoc = session.getId();
        System.out.println("Connection closed with id : " + idLoc);
        this.sessionMap.remove(idLoc);
    }


    @OnMessage
    public void onMessage(final Session session,
                          final String message) {
        System.out.println("Received message : " + message);
        try {
            session.getBasicRemote()
                   .sendText(message + " replied!.");
        } catch (Exception eLoc) {
            eLoc.printStackTrace();
        }
    }


    @OnError
    public void onError(final Session session,
                        final Throwable throwable) {
        try {
            session.close();
            String idLoc = session.getId();
            System.out.println("Connection error with id : " + idLoc);
            this.sessionMap.remove(idLoc);
        } catch (Exception eLoc) {
            eLoc.printStackTrace();
        }
    }


}
