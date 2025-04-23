package ProyectoFinal.Controller;

/**
 *
 * @author maria
 */


import ProyectoFinal.formulario.domain.ReporteCalidad;
import ProyectoFinal.Service.ReporteCalidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/calidad")
public class ReporteCalidadController {

    @Autowired
    private ReporteCalidadService calidadService;

    @GetMapping("/reporte")
    public String mostrarFormulario(ReporteCalidad reporteCalidad) {
        return "Calidad/ReporteCalidad"; // Este es el HTML en la carpeta correcta
    }

    @PostMapping("/guardar")
    public String guardarReporte(@ModelAttribute ReporteCalidad reporteCalidad, Model model) {
        calidadService.save(reporteCalidad);
        model.addAttribute("mensaje", "Reporte de calidad guardado exitosamente.");
        return "redirect:/"; // Cambiar lo va a redirigir a una página específica
    }
}
