package org.example.controllers;

import org.example.models.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @MessageMapping("/sendMessage")
    @SendTo("/topic/public")
    public Message sendMessage(Message chatMessage) {
        return chatMessage;
    }
}
