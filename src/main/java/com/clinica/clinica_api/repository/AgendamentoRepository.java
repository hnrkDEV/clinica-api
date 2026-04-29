package com.clinica.clinica_api.repository;

import com.clinica.clinica_api.entity.Agendamento;
import com.clinica.clinica_api.enums.StatusAgendamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

    boolean existsByProfissionalIdAndDataHoraAndStatus(
            Long profissionalId,
            LocalDateTime dataHora,
            StatusAgendamento status
    );

    List<Agendamento> findByPacienteId(Long pacienteId);

    List<Agendamento> findByProfissionalId(Long profissionalId);

    List<Agendamento> findByStatus(StatusAgendamento status);
}