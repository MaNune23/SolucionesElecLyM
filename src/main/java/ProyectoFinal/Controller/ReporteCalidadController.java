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
@RequestMapping("/calidad")
public class ReporteCalidadController {
@Autowired
    private ReporteCalidadService calidadService;

    @GetMapping("/ReporteCalidad")
    public String mostrarReporte(ReporteCalidad reporteCalidad) {
        return "/calidad/reporteCalidad";
    }

    @PostMapping("/guardar")
    public String guardarReporteC (ReporteCalidad reporteCalidad) {
        reporteCalidadService.save(reporteCalidad);
        return "redirect:/";
    }
}
