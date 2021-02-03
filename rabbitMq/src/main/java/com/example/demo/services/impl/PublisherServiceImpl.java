package com.example.demo.services.impl;

import com.example.demo.services.PublisherService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class PublisherServiceImpl implements PublisherService {

    private static final Logger LOGGER = LogManager.getLogger(PublisherServiceImpl.class);

    private RabbitTemplate template;

    @Autowired
    public PublisherServiceImpl(RabbitTemplate template) {
        this.template = template;
    }

    @Override
    public void send(String message) {
        getTemplate().convertAndSend("exchange", "", message);
        LOGGER.info("RECEIVED_MESSAGE_SENT: " + message);
    }


    @PostConstruct
    public void sendMessage() {
        String message = "Hello on startup!";
        getTemplate().convertAndSend("exchange", "", message);
        LOGGER.info("INITIAL_MESSAGE_SENT: " + message);
    }

    public RabbitTemplate getTemplate() {
        return template;
    }
}
