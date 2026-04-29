package com.clinica.clinica_api.repository;

import com.clinica.clinica_api.entity.Profissional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfissionalRepository extends JpaRepository<Profissional, Long> {
}