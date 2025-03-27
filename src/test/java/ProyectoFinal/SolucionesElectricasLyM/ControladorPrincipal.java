package ProyectoFinal.SolucionesElectricasLyM;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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

}