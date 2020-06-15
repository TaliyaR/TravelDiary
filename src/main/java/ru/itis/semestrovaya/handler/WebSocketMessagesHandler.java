package ru.itis.semestrovaya.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import ru.itis.semestrovaya.models.Message;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@EnableWebSocket
public class WebSocketMessagesHandler extends TextWebSocketHandler {

    private static final Map<String, WebSocketSession> sessions = new HashMap<>();

    private List<String> toDelete = new ArrayList();

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        String messageText = (String) message.getPayload();
        Message messageFromJson = objectMapper.readValue(messageText, Message.class);

        if (!sessions.containsKey(messageFromJson.getFrom())) {
            sessions.put(session.getId(), session);
        }

        if (messageFromJson.getText() != null) {
            for (Map.Entry<String, WebSocketSession> stringWebSocketSessionEntry : sessions.entrySet()) {
                try {
                    stringWebSocketSessionEntry.getValue().sendMessage(message);
                } catch (Exception e) {
                    synchronized (sessions) {
                        toDelete.add(stringWebSocketSessionEntry.getKey());
                    }
                }
            }
        }
        for (String str : toDelete) {
            sessions.remove(str);
        }
        toDelete.clear();
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        sessions.put(session.getId(), session);
    }
}
