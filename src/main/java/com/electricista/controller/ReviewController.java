/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.electricista.controller;
import com.electricista.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author joshu
 */
@Controller
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @GetMapping("/electricians/{id}/reviews")
    public String viewReviews(@PathVariable Long id, Model model) {
        model.addAttribute("reviews", reviewService.getReviewsByElectricianId(id));
        return "electricians/reviews"; // Plantilla para mostrar reseñas
    }
}

