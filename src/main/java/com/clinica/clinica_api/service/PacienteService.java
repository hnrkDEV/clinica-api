package com.clinica.clinica_api.service;

import com.clinica.clinica_api.entity.Paciente;

import java.util.List;

public interface PacienteService {

    Paciente cadastrar(Paciente paciente);

    List<Paciente> listar();
}