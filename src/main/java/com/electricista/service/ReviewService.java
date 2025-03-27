/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.electricista.service;

import com.electricista.dao.ReviewRepository;
import com.electricista.domain.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 *
 * @author joshu
 */
@Service
public class ReviewService {
    @Autowired
    private ReviewRepository repository;

    public List<Review> getReviewsByElectricianId(Long electricianId) {
        return repository.findByElectricianId(electricianId);
    }

    public Review saveReview(Review review) {
        return repository.save(review);
    }
}

