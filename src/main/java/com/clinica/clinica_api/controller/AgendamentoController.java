package com.clinica.clinica_api.controller;

import com.clinica.clinica_api.dto.request.AgendamentoRequest;
import com.clinica.clinica_api.dto.request.CancelamentoRequest;
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
    public Agendamento criar(@RequestBody @Valid AgendamentoRequest request) {
        Agendamento agendamento = Agendamento.builder()
                .tipoAtendimento(request.tipoAtendimento())
                .build();

        return agendamentoService.criar(
                request.pacienteId(),
                request.profissionalId(),
                request.dataHora(),
                agendamento
        );
    }

    @GetMapping
    public List<Agendamento> listar(
            @RequestParam(required = false) Long pacienteId,
            @RequestParam(required = false) Long profissionalId,
            @RequestParam(required = false) StatusAgendamento status
    ) {
        return agendamentoService.listar(pacienteId, profissionalId, status);
    }

    @PatchMapping("/{id}/cancelar")
    public Agendamento cancelar(
            @PathVariable Long id,
            @RequestBody @Valid CancelamentoRequest request
    ) {
        return agendamentoService.cancelar(id, request.motivo());
    }
}