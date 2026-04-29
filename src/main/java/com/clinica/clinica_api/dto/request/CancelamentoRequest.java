package com.clinica.clinica_api.dto.request;

import jakarta.validation.constraints.NotBlank;

public record CancelamentoRequest(
        @NotBlank String motivo
) {
}