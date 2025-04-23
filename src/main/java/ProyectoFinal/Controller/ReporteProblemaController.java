package ProyectoFinal.Controller;

/**
 *
 * @author maria
 */


import ProyectoFinal.formulario.domain.ReporteProblema;
import ProyectoFinal.Service.ReporteProblemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/problema")
public class ReporteProblemaController {

    @Autowired
    private ReporteProblemaService problemaService;

    @GetMapping("/formulario")
    public String mostrarFormulario(ReporteProblema reporteProblema) {
        return "Calidad/ReporteProblema"; // Verificá que exista esta vista HTML
    }

    @PostMapping("/guardar")
    public String guardarReporte(@ModelAttribute ReporteProblema reporteProblema, Model model) {
        problemaService.save(reporteProblema);
        model.addAttribute("mensaje", "Reporte de problema guardado exitosamente.");
        return "redirect:/";
    }
}
