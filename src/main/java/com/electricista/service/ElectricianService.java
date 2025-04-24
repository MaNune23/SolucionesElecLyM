/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.electricista.service;

/**
 *
 * @author maria
 */
import com.electricista.domain.Electrician;
import java.util.List;

public interface ElectricianService {

    List<Electrician> getElectricistas(boolean activos);

    void save(Electrician electrician);

    void delete(Electrician electrician);

    Electrician getElectricista(Electrician electrician);
}
