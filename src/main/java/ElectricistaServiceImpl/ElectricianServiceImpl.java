package ElectricistaServiceImpl;

import com.electricista.dao.ElectricianRepository;
import com.electricista.domain.Electrician;
import com.electricista.service.ElectricianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElectricianServiceImpl implements ElectricianService {

    @Autowired
    private ElectricianRepository electricianRepository;

    @Override
    public List<Electrician> getElectricistas(boolean activos) {
        return electricianRepository.findAll(); // Puedes filtrar por 'activo' si tu entidad tiene esa propiedad
    }

    @Override
    public void save(Electrician electrician) {
        electricianRepository.save(electrician);
    }

    @Override
    public void delete(Electrician electrician) {
        electricianRepository.delete(electrician);
    }

    @Override
    public Electrician getElectricista(Electrician electrician) {
        return electricianRepository.findById(electrician.getIdElectrician()).orElse(null);
    }
}
