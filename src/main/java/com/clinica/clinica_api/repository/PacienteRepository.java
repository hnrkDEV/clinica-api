package com.clinica.clinica_api.repository;

import com.clinica.clinica_api.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}