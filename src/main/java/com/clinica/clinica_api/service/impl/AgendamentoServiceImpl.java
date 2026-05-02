package com.clinica.clinica_api.service.impl;

import com.clinica.clinica_api.adapter.AuditoriaAdapter;
import com.clinica.clinica_api.entity.Agendamento;
import com.clinica.clinica_api.entity.Paciente;
import com.clinica.clinica_api.entity.Profissional;
import com.clinica.clinica_api.enums.StatusAgendamento;
import com.clinica.clinica_api.exception.BusinessException;
import com.clinica.clinica_api.exception.NotFoundException;
import com.clinica.clinica_api.repository.AgendamentoRepository;
import com.clinica.clinica_api.repository.AuditoriaRepository;
import com.clinica.clinica_api.repository.PacienteRepository;
import com.clinica.clinica_api.repository.ProfissionalRepository;
import com.clinica.clinica_api.service.AgendamentoService;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AgendamentoServiceImpl implements AgendamentoService {

    private final AgendamentoRepository agendamentoRepository;
    private final PacienteRepository pacienteRepository;
    private final ProfissionalRepository profissionalRepository;
    private final AuditoriaRepository auditoriaRepository;

    @Override
    @Transactional
    public Agendamento criar(Long pacienteId, Long profissionalId, LocalDateTime dataHora, Agendamento agendamento) {

        if (dataHora.isBefore(LocalDateTime.now())) {
            throw new BusinessException("Não é permitido criar agendamento com data/hora no passado.");
        }

        boolean existeConflito = agendamentoRepository.existsByProfissionalIdAndDataHoraAndStatus(
                profissionalId,
                dataHora,
                StatusAgendamento.AGENDADO
        );

        if (existeConflito) {
            throw new BusinessException("Profissional já possui agendamento nesse horário.");
        }

        Paciente paciente = pacienteRepository.findById(pacienteId)
                .orElseThrow(() -> new NotFoundException("Paciente não encontrado."));

        Profissional profissional = profissionalRepository.findById(profissionalId)
                .orElseThrow(() -> new NotFoundException("Profissional não encontrado."));

        agendamento.setPaciente(paciente);
        agendamento.setProfissional(profissional);
        agendamento.setDataHora(dataHora);
        agendamento.setStatus(StatusAgendamento.AGENDADO);
        agendamento.setMotivoCancelamento(null);

        Agendamento agendamentoSalvo = agendamentoRepository.save(agendamento);

        auditoriaRepository.save(
                AuditoriaAdapter.agendamentoCriado(agendamentoSalvo)
        );

        return agendamentoSalvo;


    }

    @Override
    public List<Agendamento> listar(Long pacienteId, Long profissionalId, StatusAgendamento status) {

        if (pacienteId != null) {
            return agendamentoRepository.findByPacienteId(pacienteId);
        }

        if (profissionalId != null) {
            return agendamentoRepository.findByProfissionalId(profissionalId);
        }

        if (status != null) {
            return agendamentoRepository.findByStatus(status);
        }

        return agendamentoRepository.findAll();
    }

    @Override
    @Transactional
    public Agendamento cancelar(Long id, String motivo) {

        if (motivo == null || motivo.isBlank()) {
           throw new BusinessException("O motivo do cancelamento é obrigatório.");
        }

        Agendamento agendamento = agendamentoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Agendamento não encontrado."));

        agendamento.setStatus(StatusAgendamento.CANCELADO);
        agendamento.setMotivoCancelamento(motivo);

        Agendamento agendamentoCancelado = agendamentoRepository.save(agendamento);

        auditoriaRepository.save(
                AuditoriaAdapter.agendamentoCancelado(agendamentoCancelado, motivo)
        );

        return agendamentoCancelado;
    }
}