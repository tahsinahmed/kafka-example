package com.tahsin.kafkaexample;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class MessageController {

    private final KafkaTemplate<String, String> template;

    public MessageController(KafkaTemplate<String, String> template) {
        this.template = template;
    }

    @PostMapping
    public void publish(@RequestBody MessageRequest request) {
        template.send("test-topic", request.message());
    }
}
