package com.clinica.clinica_api.controller;

import com.clinica.clinica_api.adapter.AgendamentoAdapter;
import com.clinica.clinica_api.dto.request.AgendamentoRequest;
import com.clinica.clinica_api.dto.request.CancelamentoRequest;
import com.clinica.clinica_api.dto.response.AgendamentoResponse;
import com.clinica.clinica_api.entity.Agendamento;
import com.clinica.clinica_api.enums.StatusAgendamento;
import com.clinica.clinica_api.service.AgendamentoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agendamentos")
@RequiredArgsConstructor
public class AgendamentoController {

    private final AgendamentoService agendamentoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AgendamentoResponse criar(@RequestBody @Valid AgendamentoRequest request) {

        Agendamento agendamento = AgendamentoAdapter.toEntity(request);

        Agendamento salvo = agendamentoService.criar(
                request.pacienteId(),
                request.profissionalId(),
                request.dataHora(),
                agendamento
        );

        return AgendamentoAdapter.toResponse(salvo);
    }

    @GetMapping
    public List<AgendamentoResponse> listar(
            @RequestParam(required = false) Long pacienteId,
            @RequestParam(required = false) Long profissionalId,
            @RequestParam(required = false) StatusAgendamento status
    ) {
        return agendamentoService.listar(pacienteId, profissionalId, status)
                .stream()
                .map(AgendamentoAdapter::toResponse)
                .toList();
    }

    @PatchMapping("/{id}/cancelar")
    public AgendamentoResponse cancelar(
            @PathVariable Long id,
            @RequestBody @Valid CancelamentoRequest request
    ) {
        Agendamento cancelado = agendamentoService.cancelar(id, request.motivo());
        return AgendamentoAdapter.toResponse(cancelado);
    }
}