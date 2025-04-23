/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoFinal.ServiceImpl;

/**
 *
 * @author maria
 */


import ProyectoFinal.Service.ReporteCalidadService;
import ProyectoFinal.formulario.domain.ReporteCalidad;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReporteCalidadServiceImpl implements ReporteCalidadService {

    private final List<ReporteCalidad> reportes = new ArrayList<>();

    @Override
    public void save(ReporteCalidad reporteCalidad) {
        reportes.add(reporteCalidad); // simulado (sin BD real por ahora)
    }
}
