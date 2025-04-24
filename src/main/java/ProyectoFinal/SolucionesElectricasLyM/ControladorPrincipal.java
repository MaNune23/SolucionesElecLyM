package ProyectoFinal.SolucionesElectricasLyM;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.electricista.domain.Electrician;
import com.electricista.domain.Request;
import com.electricista.service.EmailService;
import com.electricista.service.RequestService;
import com.electricista.service.ElectricianSimpleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Controller
public class ControladorPrincipal {

    @GetMapping("/")
    public String mostrarLogin() {
        return "Login"; // src/main/resources/templates/Login.html
    }

    @GetMapping("/home")
    public String mostrarHomePage() {
        return "HomePage"; // src/main/resources/templates/HomePage.html
    }

    @GetMapping("/crear-cuenta")
    public String mostrarCrearCuenta() {
        return "CrearCuenta"; // src/main/resources/templates/CrearCuenta.html
    }

    @GetMapping("/perfil")
    public String mostrarPerfil() {
        return "MiPerfil"; // src/main/resources/templates/MiPerfil.html
    }

    @GetMapping("/metodospago")
    public String mostrarMetodosPago() {
        return "MetodosPago"; // src/main/resources/templates/MetodosPago.html
    }

@GetMapping("/terminoscondiciones")
public String verTerminos() {
    return "TerminosCondiciones"; // nombre del archivo HTML
}
@GetMapping("/seguimiento")
public String mostrarSeguimiento() {
    return "seguimiento";
}
@RequestMapping("/requests")
public class RequestController {

    @Autowired
    private RequestService service;

    @Autowired
    private ElectricianSimpleService electricianService; //

    @Autowired
    private EmailService emailService;

    @GetMapping
    public String listRequests(Model model) {
        model.addAttribute("requests", service.getAllRequests());
        return "list";
    }

    @GetMapping("/new")
    public String newRequestForm(@RequestParam(value = "service", required = false) String service, Model model) {
        Request request = new Request();
        if (service != null) {
            request.setDescription(service);
        }
        model.addAttribute("request", request);
        model.addAttribute("electricians", electricianService.getAllElectricians()); //
        return "new";
    }

    @PostMapping
    public String saveRequest(@ModelAttribute Request request,
                              @RequestParam("email") String email,
                              @RequestParam("electrician") String electrician,
                              @RequestParam("latitude") double latitude,
                              @RequestParam("longitude") double longitude,
                              @RequestParam("image") MultipartFile file) throws IOException {

        if (electrician.equals("random")) {
            List<String> electricians = electricianService.getAllElectricians().stream()
                    .map(Electrician::getName)
                    .collect(Collectors.toList());
            request.setElectrician(electricians.get(new Random().nextInt(electricians.size())));
        } else {
            request.setElectrician(electrician);
        }

        request.setLatitude(latitude);
        request.setLongitude(longitude);

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

        request.setStatus("Pendiente");
        service.saveRequest(request);

        String subject = "Confirmación de Cita - Solicitud #" + request.getId();
        String text = "Gracias por crear una solicitud.\n" +
                      "Electricista asignado: " + request.getElectrician() + "\n" +
                      "Descripción: " + request.getDescription() + "\n" +
                      "Ubicación: Latitud " + latitude + ", Longitud " + longitude + "\n" +
                      "Estado actual: " + request.getStatus() + "\n";

        emailService.sendConfirmationEmail(email, subject, text);

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
        return "view";
    }

    @GetMapping("/history")
    public String showHistoryPage(Model model) {
        return "history";
    }

    @GetMapping("/delete/{id}")
    public String deleteRequest(@PathVariable Long id) {
        service.deleteRequest(id);
        return "redirect:/requests";
    }



    @GetMapping("/service_request")
    public String showServiceRequestPage(Model model) {
        return "service_request";
    }
}
}