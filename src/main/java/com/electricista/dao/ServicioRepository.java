/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.electricista.dao;
import com.electricas.soluciones.model.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sergi
 */
// Repositorio
@Repository
public interface ServicioRepository extends JpaRepository<Servicio, Long> {
}

