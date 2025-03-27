/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.electricista.service;
import com.electricista.dao.ElectricianRepository;
import com.electricista.domain.Electrician;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 *
 * @author joshu
 */
@Service
public class ElectricianService {
    @Autowired
    private ElectricianRepository repository;

    public List<Electrician> getAllElectricians() {
        return repository.findAll();
    }
}


