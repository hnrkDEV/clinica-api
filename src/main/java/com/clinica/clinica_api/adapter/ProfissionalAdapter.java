package com.clinica.clinica_api.adapter;

import com.clinica.clinica_api.dto.request.ProfissionalRequest;
import com.clinica.clinica_api.entity.Profissional;

public class ProfissionalAdapter {

    public static Profissional toEntity(ProfissionalRequest request) {
        return Profissional.builder()
                .nome(request.nome())
                .especialidade(request.especialidade())
                .build();
    }
}