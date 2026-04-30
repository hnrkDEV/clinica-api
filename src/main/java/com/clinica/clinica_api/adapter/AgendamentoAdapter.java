package com.clinica.clinica_api.adapter;

import com.clinica.clinica_api.dto.request.AgendamentoRequest;
import com.clinica.clinica_api.dto.response.AgendamentoResponse;
import com.clinica.clinica_api.entity.Agendamento;

public class AgendamentoAdapter {

    public static Agendamento toEntity(AgendamentoRequest request) {
        return Agendamento.builder()
                .tipoAtendimento(request.tipoAtendimento())
                .build();
    }

    public static AgendamentoResponse toResponse(Agendamento agendamento) {
        return new AgendamentoResponse(
                agendamento.getId(),
                agendamento.getPaciente().getNome(),
                agendamento.getProfissional().getNome(),
                agendamento.getDataHora(),
                agendamento.getTipoAtendimento(),
                agendamento.getStatus()
        );
    }
}