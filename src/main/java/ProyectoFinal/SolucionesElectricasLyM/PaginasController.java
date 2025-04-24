package ProyectoFinal.SolucionesElectricasLyM;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author sergi
 */
@Controller
public class PaginasController {

    @GetMapping("/Solicitar_Servicio")
    public String mostrarFormularioServicio() {
        return "Solicitar_Servicio"; // Este nombre debe coincidir con el HTML en /templates
    }

    @GetMapping("/resenas")
    public String mostrarResenas() {
        return "resenas"; // sin la extensión .html

    }

    @GetMapping("/contactanos")
    public String mostrarChat() {
        return "chat"; // archivo: chat.html en templates
    }

    @GetMapping("/productos")
    public String mostrarProductos() {
        return "productos"; // archivo: productos.html en templates
    }

    @GetMapping("/nuestrosproyectos")
    public String mostrarProyectos() {
        return "nuestrosproyectos"; // archivo: nuestrosproyectos.html en templates
    }
    
        @GetMapping("/Seguimiento")
    public String mostrarSeguimiento() {
        return "Seguimiento"; 
    }
    
      @GetMapping("/history")
    public String mostrarhistory() {
        return "history"; 
    }
    

}
