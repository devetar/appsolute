package org.example.payload.request;

import javax.validation.constraints.NotBlank;

public class MessageRequest {
    @NotBlank
    private String username;

    @NotBlank
    private String message;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
