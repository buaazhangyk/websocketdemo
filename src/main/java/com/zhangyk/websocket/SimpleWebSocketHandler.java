package com.zhangyk.websocket;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

/**
 * Created by yunkai on 7/8/17.
 */
public class SimpleWebSocketHandler implements WebSocketHandler {

    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("connect to the websocket success......");
        session.sendMessage(new TextMessage("Server:connected OK!"));
    }

    public void handleMessage(WebSocketSession wss, WebSocketMessage<?> wsm) throws Exception {
        TextMessage returnMessage = new TextMessage(wsm.getPayload()
            + " received at server");
        System.out.println("receive: " + wsm.getPayload());
        System.out.println(wss.getHandshakeHeaders().getFirst("Cookie"));
        wss.sendMessage(returnMessage);
    }

    public void handleTransportError(WebSocketSession wss, Throwable thrwbl) throws Exception {
        if(wss.isOpen()){
            wss.close();
        }
        System.out.println("websocket connection closed......");
    }

    public void afterConnectionClosed(WebSocketSession wss, CloseStatus cs) throws Exception {
        System.out.println("websocket connection closed......");
    }

    public boolean supportsPartialMessages() {
        return false;
    }
}
