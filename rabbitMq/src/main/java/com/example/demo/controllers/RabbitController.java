package com.example.demo.controllers;

import com.example.demo.services.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RabbitController {

    private PublisherService publisherService;

    @Autowired
    public RabbitController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @PostMapping(value = "/sendMessage", consumes = "text/plain")
    public void receiveEvent(@RequestBody String message) {
        getPublisherService().send(message);
    }

    public PublisherService getPublisherService() {
        return publisherService;
    }
}
