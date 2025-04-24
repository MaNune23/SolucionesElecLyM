package com.electricista.domain;

import jakarta.persistence.*;

@Entity
public class Electrician {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idElectrician;

    private String name;
    private double rating = 0.0;
    private int reviewsCount = 0;

    // Métodos getter y setter
    public Long getIdElectrician() {
        return idElectrician;
    }

    public void setIdElectrician(Long idElectrician) {
        this.idElectrician = idElectrician;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getReviewsCount() {
        return reviewsCount;
    }

    public void setReviewsCount(int reviewsCount) {
        this.reviewsCount = reviewsCount;
    }
}
