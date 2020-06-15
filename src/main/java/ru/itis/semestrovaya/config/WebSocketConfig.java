package ru.itis.semestrovaya.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import ru.itis.semestrovaya.handler.WebSocketMessagesHandler;

@Configuration
public class WebSocketConfig implements WebSocketConfigurer {

    @Autowired
    WebSocketMessagesHandler webSocketMessagesHandler;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        webSocketHandlerRegistry.addHandler(webSocketMessagesHandler, "/chats");

    }
}
