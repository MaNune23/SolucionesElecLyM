/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.electricista.controller;
import com.electricista.domain.Message;
import com.electricista.dao.MessageRepository;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.List;
/**
 *
 * @author joshu
 */
@Controller
public class ChatController {
    private final MessageRepository messageRepository;

    public ChatController(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @MessageMapping("/sendMessage")
    @SendTo("/topic/messages")
    public Message sendMessage(String messageContent) {
        // Guardar el mensaje en la base de datos
        Message message = new Message();
        message.setContent(messageContent);
        message.setSender("Usuario"); // Puedes adaptar esto para identificar al usuario
        message.setTimestamp(LocalDateTime.now());
        messageRepository.save(message);

        return message;
    }

    @GetMapping("/api/messages")
    @ResponseBody
    public List<Message> getMessages() {
        // Retorna todos los mensajes de la base de datos
        return messageRepository.findAll();
    }
}

