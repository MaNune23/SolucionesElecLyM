/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.electricista.dao;
import com.electricista.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @author joshu
 */
@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByElectricianId(Long electricianId); // Obtener reseñas por electricista
}

