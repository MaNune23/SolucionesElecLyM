package ProyectoFinal.SolucionesElectricasLyM;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UsuarioController {

    // Mostrar formulario de registro
    @GetMapping("/crearcuenta")
    public String mostrarFormularioRegistro() {
        return "crearcuenta"; // busca crearcuenta.html
    }

    // Procesar envío del formulario
    @PostMapping("/crearcuenta")
    public String procesarRegistro(
            @RequestParam("nombre") String nombre,
            @RequestParam("correo") String correo,
            @RequestParam("clave") String clave,
            @RequestParam("confirmar") String confirmar,
            Model model
    ) {
        // Validar que las contraseñas coincidan
        if (!clave.equals(confirmar)) {
            model.addAttribute("error", "❌ Las contraseñas no coinciden.");
            return "crearcuenta";
        }

        // Aquí podrías guardar en una lista o BD en el futuro
        System.out.println("✅ Usuario creado: " + nombre + " - " + correo);

        // Redirige al login después de crear cuenta
        return "redirect:/login";
    }

    // Mostrar formulario de login
    @GetMapping("/login")
    public String mostrarLogin() {
        return "login"; // busca login.html
    }
}
