/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.electricista.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
/**
 *
 * @author joshu
 */
@Controller
public class ChatPageController {
    @GetMapping("/chat")
    public String chatPage() {
        return "chat"; // Renderiza la plantilla `chat.html`
    }
}

