package com.poly.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    // Cấu hình broker cho WebSocket
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic"); // Broker để phát tán thông điệp đến các client
        config.setApplicationDestinationPrefixes("/app"); // Tiền tố dùng cho các tin nhắn từ client đến server
    }

    // Cấu hình các endpoint WebSocket mà client có thể kết nối
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // Thêm endpoint cho WebSocket
        registry.addEndpoint("/homeuser/seat")  // Endpoint mà client sẽ kết nối
                .setAllowedOriginPatterns("http://localhost:*", "https://example.com")  // Chỉ định các origin cụ thể
                .withSockJS(); // Bật SockJS nếu cần thiết
    }
}
