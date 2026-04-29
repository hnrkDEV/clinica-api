package com.clinica.clinica_api.service.impl;

import com.clinica.clinica_api.entity.Paciente;
import com.clinica.clinica_api.repository.PacienteRepository;
import com.clinica.clinica_api.service.PacienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PacienteServiceImpl implements PacienteService {

    private final PacienteRepository pacienteRepository;

    @Override
    public Paciente cadastrar(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    @Override
    public List<Paciente> listar() {
        return pacienteRepository.findAll();
    }
}