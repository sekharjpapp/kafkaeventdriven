package com.pixel.controller;

import com.pixel.model.UserEvent;
import com.pixel.producer.UserEventProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserEventProducer userEventProducer;

    @PostMapping("/create")
    public String createUser(@RequestParam String userId, @RequestParam String name) {
        UserEvent event = new UserEvent(userId, "UserCreated", "{\"name\": \"" + name + "\"}");
        userEventProducer.sendUserEvent(event);
        return "UserCreated event sent for userId: " + userId;
    }

    @PostMapping("/update")
    public String updateUser(@RequestParam String userId, @RequestParam String newName) {
        UserEvent event = new UserEvent(userId, "UserUpdated", "{\"newName\": \"" + newName + "\"}");
        userEventProducer.sendUserEvent(event);
        return "UserUpdated event sent for userId: " + userId;
    }
}
