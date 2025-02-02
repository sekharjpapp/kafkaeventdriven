package com.pixel.producer;

import com.pixel.model.UserEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserEventProducer {

    private static final String TOPIC = "user-events";

    @Autowired
    private KafkaTemplate<String, UserEvent> kafkaTemplate;

    public void sendUserEvent(UserEvent userEvent) {
        kafkaTemplate.send(TOPIC, userEvent.getUserId(), userEvent);
    }
}
