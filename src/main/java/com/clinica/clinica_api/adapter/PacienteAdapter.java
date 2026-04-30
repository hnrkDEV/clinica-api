package com.clinica.clinica_api.adapter;

import com.clinica.clinica_api.dto.request.PacienteRequest;
import com.clinica.clinica_api.entity.Paciente;

public class PacienteAdapter {

    public static Paciente toEntity(PacienteRequest request) {
        return Paciente.builder()
                .nome(request.nome())
                .email(request.email())
                .telefone(request.telefone())
                .build();
    }
}