package com.generali.attachmentservice.activemq;

import jakarta.jms.ConnectionFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.util.ErrorHandler;

@Configuration
@EnableJms
@RequiredArgsConstructor
public class ActiveMQConfig {

    private final GeneraliErrorHandler generaliErrorHandler;

    @Bean
    public DefaultJmsListenerContainerFactory defaultJmsListenerContainerFactory(ConnectionFactory connectionFactory){
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setConcurrency("1-1");
        factory.setErrorHandler(generaliErrorHandler);
        return factory;
    }
}
