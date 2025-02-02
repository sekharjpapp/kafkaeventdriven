package com.pixel.consumer;

import com.pixel.model.UserEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class UserEventConsumer {

    @KafkaListener(topics = "user-events", groupId = "user-events-group")
    public void consume(UserEvent userEvent) {
        System.out.println("Consumed event: " + userEvent);

        // Update application state based on the event
        switch (userEvent.getEventType()) {
            case "UserCreated":
                handleUserCreated(userEvent);
                break;
            case "UserUpdated":
                handleUserUpdated(userEvent);
                break;
            default:
                System.out.println("Unknown event type: " + userEvent.getEventType());
        }
    }

    private void handleUserCreated(UserEvent userEvent) {
        // Logic to handle user creation
        System.out.println("Handling UserCreated event: " + userEvent);
    }

    private void handleUserUpdated(UserEvent userEvent) {
        // Logic to handle user update
        System.out.println("Handling UserUpdated event: " + userEvent);
    }
}
