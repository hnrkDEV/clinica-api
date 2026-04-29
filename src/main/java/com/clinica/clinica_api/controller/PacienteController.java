package com.clinica.clinica_api.controller;

import com.clinica.clinica_api.dto.request.PacienteRequest;
import com.clinica.clinica_api.entity.Paciente;
import com.clinica.clinica_api.service.PacienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
@RequiredArgsConstructor
public class PacienteController {

    private final PacienteService pacienteService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Paciente cadastrar(@RequestBody @Valid PacienteRequest request) {
        Paciente paciente = Paciente.builder()
                .nome(request.nome())
                .email(request.email())
                .telefone(request.telefone())
                .build();

        return pacienteService.cadastrar(paciente);
    }

    @GetMapping
    public List<Paciente> listar() {
        return pacienteService.listar();
    }
}