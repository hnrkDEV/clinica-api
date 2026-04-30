package com.clinica.clinica_api.service.impl;

import com.clinica.clinica_api.adapter.AuditoriaAdapter;
import com.clinica.clinica_api.entity.Paciente;
import com.clinica.clinica_api.repository.AuditoriaRepository;
import com.clinica.clinica_api.repository.PacienteRepository;
import com.clinica.clinica_api.service.PacienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PacienteServiceImpl implements PacienteService {

    private final PacienteRepository pacienteRepository;
    private final AuditoriaRepository auditoriaRepository;

    @Override
    public Paciente cadastrar(Paciente paciente) {
        Paciente pacienteSalvo = pacienteRepository.save(paciente);

        auditoriaRepository.save(
                AuditoriaAdapter.pacienteCadastrado(pacienteSalvo)
        );

        return pacienteSalvo;
    }

    @Override
    public List<Paciente> listar() {
        return pacienteRepository.findAll();
    }
}