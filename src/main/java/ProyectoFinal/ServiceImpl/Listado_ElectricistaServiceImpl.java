/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ServiceImpl;

/**
 *
 * @author gaelg
 */

import com.tienda.dao.ElectricistaDao;
import com.tienda.domain.Electricista;
import com.tienda.service.ElectricistaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

public class Listado_ElectricistaServiceImpl extends Listado_ElectricistaService{

     @Autowired
    private ElectricistaDao electricistaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Electricista> getElectricistas(boolean activos) {
        var lista = electricistaDao.findAll();
        if (activos) {
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Electricista getElectricista(Electricista electricista) {
        return electricistaDao.findById(electricista.getIdElectricista()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Electricista electricista) {
        electricistaDao.save(electricista);
    }

    @Override
    @Transactional
    public void delete(Electricista electricista) {
        electricistaDao.delete(electricista);
    }
}
