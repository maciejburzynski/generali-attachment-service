package com.generali.attachmentservice.activemq;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ActiveMQController {

    private final JmsTemplate jmsTemplate;

    @GetMapping("/api/messages")
    void consumeMessage(){
        Object object = jmsTemplate.receiveAndConvert("test");
        log.info("The message is: ");
        log.info(object.toString());
        log.info("TADAM!");
    }
}
