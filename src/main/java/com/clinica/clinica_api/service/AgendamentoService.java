package com.clinica.clinica_api.service;

import com.clinica.clinica_api.entity.Agendamento;
import com.clinica.clinica_api.enums.StatusAgendamento;

import java.time.LocalDateTime;
import java.util.List;

public interface AgendamentoService {

    Agendamento criar(Long pacienteId, Long profissionalId, LocalDateTime dataHora, Agendamento agendamento);

    List<Agendamento> listar(Long pacienteId, Long profissionalId, StatusAgendamento status);

    Agendamento cancelar(Long id, String motivo);
}