/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.electricista.service;

import com.electricas.soluciones.model.Servicio;
import com.electricas.soluciones.repository.ServicioRepository;
import org.springframework.stereotype.Service;
import java.util.List;
/**
 *
 * @author sergi
 */
// Servicio

@Service
public class ServicioService {
    private final ServicioRepository repository;

    public ServicioService(ServicioRepository repository) {
        this.repository = repository;
    }

    public List<Servicio> listarServicios() {
        return repository.findAll();
    }
}

