package com.example.demo.services.impl;

import com.example.demo.services.SubscribeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class FirstQueueSubscriber implements SubscribeService {

    private static final Logger LOGGER = LogManager.getLogger(FirstQueueSubscriber.class);

    @Override
    @RabbitListener(queues = {"firstQueue"})
    public void subscribe(String message) {
        LOGGER.info("FROM_FIRST_QUEUE: " + message);
    }


}
