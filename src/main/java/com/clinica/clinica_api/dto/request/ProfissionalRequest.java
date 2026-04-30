package com.clinica.clinica_api.dto.request;

import jakarta.validation.constraints.NotBlank;

public record ProfissionalRequest(
        @NotBlank String nome,
        @NotBlank String especialidade
) {
}