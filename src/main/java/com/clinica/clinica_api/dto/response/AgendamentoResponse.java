package com.clinica.clinica_api.dto.response;

import com.clinica.clinica_api.enums.StatusAgendamento;
import com.clinica.clinica_api.enums.TipoAtendimento;

import java.time.LocalDateTime;

public record AgendamentoResponse(
        Long id,
        String paciente,
        String profissional,
        LocalDateTime dataHora,
        TipoAtendimento tipoAtendimento,
        StatusAgendamento status
) {}