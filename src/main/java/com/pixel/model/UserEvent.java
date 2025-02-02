package com.pixel.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEvent {
    private String userId;
    private String eventType; // e.g., "UserCreated", "UserUpdated"
    private String eventData; // JSON payload

    // Constructors, getters, setters, toString
}
