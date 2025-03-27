/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.electricista.domain;

import jakarta.persistence.*;

/**
 *
 * @author joshu
 */
@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long electricianId; // ID del electricista al que pertenece la reseña
    private Long userId;        // ID del usuario que hizo la reseña
    private double rating;      // Calificación del electricista
    private String comment;     // Comentario sobre el electricista

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getElectricianId() {
        return electricianId;
    }

    public void setElectricianId(Long electricianId) {
        this.electricianId = electricianId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}