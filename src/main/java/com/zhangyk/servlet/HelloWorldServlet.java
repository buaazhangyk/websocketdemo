package com.zhangyk.servlet;

import org.eclipse.jetty.websocket.servlet.WebSocketServlet;
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory;

/**
 * Created by yunkai on 7/8/17.
 */
public class HelloWorldServlet extends WebSocketServlet
{

    @Override
    public void configure(WebSocketServletFactory webSocketServletFactory) {
        webSocketServletFactory.register(HelloWorldListener.class);
    }
}
