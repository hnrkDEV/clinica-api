package com.clinica.clinica_api.service;

import com.clinica.clinica_api.entity.Profissional;

import java.util.List;

public interface ProfissionalService {

    Profissional cadastrar(Profissional profissional);

    List<Profissional> listar();
}