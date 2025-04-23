package com.electricista.dao;

import com.electricista.domain.Electrician;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ElectricianRepository extends JpaRepository<Electrician, Long> {
}
