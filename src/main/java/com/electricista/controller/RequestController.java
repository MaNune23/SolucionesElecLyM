/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.electricista.controller;
import com.electricista.domain.Request;
import com.electricista.service.EmailService; // IMPORTANTE: Incluir el servicio de correo
import com.electricista.service.RequestService;
import com.electricista.service.ElectricianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

/**
 *
 * @author joshu
 */
@Controller
@RequestMapping("/requests")
public class RequestController {
    @Autowired
    private RequestService service;

    @Autowired
    private ElectricianService electricianService;

    @Autowired
    private EmailService emailService; // Aquí se inyecta correctamente el servicio



    @GetMapping
    public String listRequests(Model model) {
        model.addAttribute("requests", service.getAllRequests());
        return "requests/list";
    }

@GetMapping("/new")
public String newRequestForm(@RequestParam(value = "service", required = false) String service, Model model) {
    Request request = new Request();
    if (service != null) {
        request.setDescription(service); // Prellenar el campo de descripción
    }
    model.addAttribute("request", request);
    model.addAttribute("electricians", electricianService.getAllElectricians());
    return "requests/new";
}


        @PostMapping
    public String saveRequest(@ModelAttribute Request request, @RequestParam("image") MultipartFile file) throws IOException {
        if (!file.isEmpty()) {
            String uploadsDir = System.getProperty("user.dir") + "/uploads/";
            File uploadsFolder = new File(uploadsDir);

            if (!uploadsFolder.exists()) {
                uploadsFolder.mkdirs();
            }

            Path filePath = Paths.get(uploadsDir, file.getOriginalFilename());
            Files.copy(file.getInputStream(), filePath);
            request.setImageUrl("/uploads/" + file.getOriginalFilename());
        }

        request.setAppointmentDate(new Date());
        request.setStatus("Pendiente");
        service.saveRequest(request);

        // Enviar correo de confirmación
        String subject = "Confirmación de Cita - Solicitud #" + request.getId();
        String text = "Gracias por crear una solicitud.\n" +
                      "Electricista asignado: " + request.getElectrician() + "\n" +
                      "Ubicación: " + request.getLocation() + "\n" +
                      "Fecha de cita: " + request.getAppointmentDate() + "\n";
        emailService.sendConfirmationEmail("correo_del_usuario@gmail.com", subject, text);

        return "redirect:/requests";
    }



    @GetMapping("/{id}")
    public String viewRequest(@PathVariable Long id, Model model) {
        Request request = service.getRequestById(id);

        if (request == null) {
            model.addAttribute("error", "La solicitud no existe.");
            return "error";
        }

        model.addAttribute("request", request);
        return "requests/view";
    }

     @GetMapping("/history")
    public String showHistoryPage(Model model) {
        // Puedes pasar datos dinámicos desde aquí, si es necesario
        return "history";
    
    }

    @GetMapping("/delete/{id}")
    public String deleteRequest(@PathVariable Long id) {
        service.deleteRequest(id);
        return "redirect:/requests";
    }



    @GetMapping("/service_request")
    public String showServiceRequestPage(Model model) {
        // Puedes agregar lógica aquí si deseas cargar datos dinámicos
        return "service_request";
    }
}



