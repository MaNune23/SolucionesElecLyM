/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.electricista.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



/**
 *
 * @author joshu
 */
@Controller
public class ServiceController {

    @GetMapping("/service_request")
    public String showServiceRequestPage(Model model) {
        return "service_request"; // Vincula con la plantilla "service_request.html"
    }
}

