package com.clinica.clinica_api.controller;

import com.clinica.clinica_api.adapter.PacienteAdapter;
import com.clinica.clinica_api.dto.request.PacienteRequest;
import com.clinica.clinica_api.entity.Paciente;
import com.clinica.clinica_api.service.PacienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@Tag(name = "Pacientes", description = "Cadastro e listagem de pacientes")
@RestController
@RequestMapping("/pacientes")
@RequiredArgsConstructor
public class PacienteController {

    private final PacienteService pacienteService;

    @Operation(
            summary = "Cadastrar paciente",
            description = "Cadastra um novo paciente e registra a ação na auditoria."
    )
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Paciente cadastrar(@RequestBody @Valid PacienteRequest request) {
        Paciente paciente = PacienteAdapter.toEntity(request);

        return pacienteService.cadastrar(paciente);
    }

    @Operation(
            summary = "Listar pacientes",
            description = "Lista todos os pacientes cadastrados."
    )
    @GetMapping
    public List<Paciente> listar() {
        return pacienteService.listar();
    }
}