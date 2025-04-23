package ProyectoFinal.ServiceImpl;

import ProyectoFinal.Service.ReporteProblemaService;
import ProyectoFinal.formulario.domain.ReporteProblema;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReporteProblemaServiceImpl implements ReporteProblemaService {

    private final List<ReporteProblema> problemas = new ArrayList<>();

    @Override
    public void save(ReporteProblema reporteProblema) {
        problemas.add(reporteProblema); // Simulación temporal
    }
}
