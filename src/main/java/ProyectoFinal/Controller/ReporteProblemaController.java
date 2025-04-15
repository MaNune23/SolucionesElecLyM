/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Controller;

/**
 *
 * @author gaelg
 */
import com.tienda.domain.ReporteProblema;
import com.tienda.service.ReporteProblemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/problema")
public class ReporteProblemaController {

    @Autowired
    private ReporteProblemaService problemaService;

    @GetMapping("/formulario")
    public String mostrarFormulario(ReporteProblema reporteProblema) {
        return "/problema/formularioProblema";
    }

    @PostMapping("/guardar")
    public String guardarReporte(ReporteProblema reporteProblema) {
        problemaService.save(reporteProblema);
        return "redirect:/";
    }
}
