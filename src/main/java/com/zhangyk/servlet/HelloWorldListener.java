package com.zhangyk.servlet;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.WebSocketListener;

/**
 * Created by yunkai on 7/8/17.
 */
public class HelloWorldListener implements WebSocketListener
{

    public void onWebSocketBinary(byte[] payload, int offset, int len) {
        System.out.println("onWebSocketBinary");
    }

    public void onWebSocketClose(int statusCode, String reason) {
        System.out.println("onWebSocketClose");
    }

    public void onWebSocketConnect(Session session) {
        System.out.println("onWebSocketConnect");
    }

    public void onWebSocketError(Throwable cause) {
        System.out.println("onWebSocketError");
    }

    public void onWebSocketText(String message) {
        System.out.println("onWebSocketText");
    }
}
