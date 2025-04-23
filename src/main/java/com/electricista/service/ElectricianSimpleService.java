package com.electricista.service;

import com.electricista.dao.ElectricianRepository;
import com.electricista.domain.Electrician;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElectricianSimpleService {

    @Autowired
    private ElectricianRepository repository; 

    public List<Electrician> getAllElectricians() {
        return repository.findAll();
    }
}
