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
        return "service_request";
    }
}
