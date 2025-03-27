/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.electricista.dao;
import com.electricista.domain.Electrician;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 *
 * @author joshu
 */
@Repository
public interface ElectricianRepository extends JpaRepository<Electrician, Long> {
}
