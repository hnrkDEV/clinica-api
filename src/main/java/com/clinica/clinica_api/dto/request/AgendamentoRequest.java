package com.clinica.clinica_api.dto.request;

import com.clinica.clinica_api.enums.TipoAtendimento;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record AgendamentoRequest(
        @NotNull Long pacienteId,
        @NotNull Long profissionalId,
        @NotNull @Future LocalDateTime dataHora,
        @NotNull TipoAtendimento tipoAtendimento
) {
}