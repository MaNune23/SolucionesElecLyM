package Historias_Usuario;

import com.tienda.domain.Electricista;
import com.tienda.service.ElectricistaService;
import com.tienda.service.impl.FirebaseStorageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/electricista")
public class Listado_ElectricistaController {

    @Autowired
    private ElectricistaService electricistaService;

    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;

    @GetMapping("/listado")
    private String listado(Model model) {
        var electricistas = electricistaService.getElectricistas(false);
        model.addAttribute("electricistas", electricistas);
        model.addAttribute("totalElectricistas", electricistas.size());
        return "/electricista/listado";
    }

    @GetMapping("/nuevo")
    public String electricistaNuevo(Electricista electricista) {
        return "/electricista/modifica";
    }

    @PostMapping("/guardar")
    public String electricistaGuardar(Electricista electricista,
                                      @RequestParam("imagenFile") MultipartFile imagenFile) {
        if (!imagenFile.isEmpty()) {
            electricistaService.save(electricista);
            electricista.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile,
                            "electricista",
                            electricista.getIdElectricista()));
        }
        electricistaService.save(electricista);
        return "redirect:/electricista/listado";
    }

    @GetMapping("/eliminar/{idElectricista}")
    public String electricistaEliminar(Electricista electricista) {
        electricistaService.delete(electricista);
        return "redirect:/electricista/listado";
    }

    @GetMapping("/modificar/{idElectricista}")
    public String electricistaModificar(Electricista electricista, Model model) {
        electricista = electricistaService.getElectricista(electricista);
        model.addAttribute("electricista", electricista);
        return "/electricista/modifica";
    }
}
