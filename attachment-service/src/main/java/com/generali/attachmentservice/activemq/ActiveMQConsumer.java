package com.generali.attachmentservice.activemq;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@Slf4j
public class ActiveMQConsumer {


    private final JmsTemplate jmsTemplate;


    @JmsListener(destination = "test")
    void consumeMessage(String message) throws JsonProcessingException {
        log.info("The message is: ");
        log.info(message);
        log.info("TADAM!");


        ObjectMapper objectMapper = new ObjectMapper();
        OrderDto orderDto = objectMapper.readValue(message, OrderDto.class);
        log.info("New object is born!");
        log.info("OrderDto: {}", orderDto);
    }
}
