/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.electricista.service;

import com.electricista.dao.RequestRepository;
import com.electricista.domain.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author joshu
 */
@Service
public class RequestService {

    @Autowired
    private RequestRepository repository;

    public List<Request> getAllRequests() {
        return repository.findAll();
    }

    public Request getRequestById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Request saveRequest(Request request) {
        return repository.save(request);
    }

    public void deleteRequest(Long id) {
        repository.deleteById(id);
    }
}
