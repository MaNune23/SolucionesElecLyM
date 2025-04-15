/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package Service;

/**
 *
 * @author gaelg
 */
import com.tienda.domain.Electricista;
import java.util.List;
public interface Listado_ElectricistaService {

    // Se obtiene listado de electricistas desde la BD
    public List<Electricista> getElectricistas(boolean activos);

    // Se obtiene un Electricista a partir de su id
    public Electricista getElectricista(Electricista electricista);

    // Inserta un nuevo electricista si su id está vacío
    // Actualiza un electricista si el id NO está vacío
    public void save(Electricista electricista);

    // Elimina el electricista que tiene el id dado
    public void delete(Electricista electricista);
}
