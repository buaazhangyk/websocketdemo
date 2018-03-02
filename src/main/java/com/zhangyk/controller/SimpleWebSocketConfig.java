package com.zhangyk.controller;

import com.zhangyk.websocket.SimpleWebSocketHandler;
import com.zhangyk.websocket.SimpleWebSocketInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.HandshakeInterceptor;

/**
 * Created by yunkai on 7/8/17.
 */
@Configuration
@EnableWebSocket
@EnableWebMvc
public class SimpleWebSocketConfig implements WebSocketConfigurer {

    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(myhandler(), "/sockjs/websocket").addInterceptors(myInterceptors()).withSockJS();
    }

    @Bean
    public WebSocketHandler myhandler() {
        return new SimpleWebSocketHandler();
    }

    @Bean
    public HandshakeInterceptor myInterceptors() {
        return new SimpleWebSocketInterceptor();
    }
}
