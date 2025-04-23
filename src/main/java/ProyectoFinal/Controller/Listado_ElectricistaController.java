package ProyectoFinal.Controller;

import com.electricista.domain.Electrician;
import com.electricista.service.ElectricianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/electricista")
public class Listado_ElectricistaController {

    @Autowired
    private ElectricianService electricianService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var electricistas = electricianService.getElectricistas(false);
        model.addAttribute("electricistas", electricistas);
        model.addAttribute("totalElectricistas", electricistas.size());
        return "Listado_Electricistas/lista_Electricistas";
    }

    @GetMapping("/nuevo")
    public String electricistaNuevo(Electrician electrician) {
        return "Listado_Electricistas/modifica";
    }

    @PostMapping("/guardar")
    public String electricistaGuardar(Electrician electrician) {
        electricianService.save(electrician);
        return "redirect:/electricista/listado";
    }

    @GetMapping("/eliminar/{idElectrician}")
    public String electricistaEliminar(@PathVariable Long idElectrician) {
        Electrician temp = new Electrician();
        temp.setIdElectrician(idElectrician);
        electricianService.delete(temp);
        return "redirect:/electricista/listado";
    }

    @GetMapping("/modificar/{idElectrician}")
    public String electricistaModificar(@PathVariable Long idElectrician, Model model) {
        Electrician temp = new Electrician();
        temp.setIdElectrician(idElectrician);
        Electrician electrician = electricianService.getElectricista(temp);
        model.addAttribute("electricista", electrician);
        return "Listado_Electricistas/modifica";
    }
}
