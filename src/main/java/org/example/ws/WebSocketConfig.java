package org.example.ws;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocketMessageBroker
//public class WebSocketConfig implements WebSocketConfigurer {
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

//    private final ChatWebSocketHandler chatWebSocketHandler;
//
//    public WebSocketConfig(ChatWebSocketHandler chatWebSocketHandler) {
//        this.chatWebSocketHandler = chatWebSocketHandler;
//    }
//
//    @Override
//    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
//        registry.addHandler(chatWebSocketHandler, "/chat").setAllowedOrigins("*");
//    }
@Override
public void configureMessageBroker(MessageBrokerRegistry config) {
    config.enableSimpleBroker("/topic");
    config.setApplicationDestinationPrefixes("/app");
}


    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/chat").setAllowedOrigins("*").withSockJS();
    }
}
