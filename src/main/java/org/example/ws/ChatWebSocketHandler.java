package org.example.ws;

import org.example.ent.Message;
import org.example.ent.Usr;
import org.example.svc.MessageService;
import org.example.svc.UsrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.ArrayList;
import java.util.List;

@Component
public class ChatWebSocketHandler extends TextWebSocketHandler {
    @Autowired
    private MessageService messageService;
    @Autowired
    private UsrService usrService;

    private final List<WebSocketSession> sessions = new ArrayList<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        // Get the authenticated user details
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();

        // Store the username in the session attributes
        session.getAttributes().put("username", username);

        // Add the session to the list
        sessions.add(session);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage textMessage) throws Exception {
        String payload = textMessage.getPayload();

        String username = (String) session.getAttributes().get("username");
        Usr usr = usrService.findByUsername(username);
        Message message = new Message(usr, payload);
        messageService.save(message);

        for (WebSocketSession s : sessions) {
            s.sendMessage(new TextMessage(message.printable()));
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
        sessions.remove(session);
    }
}
