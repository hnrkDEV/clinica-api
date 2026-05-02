package com.clinica.clinica_api.controller;

import com.clinica.clinica_api.entity.Profissional;
import com.clinica.clinica_api.service.ProfissionalService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@Tag(name = "Profissionais", description = "Cadastro e listagem de profissionais")
@RestController
@RequestMapping("/profissionais")
@RequiredArgsConstructor
public class ProfissionalController {

    private final ProfissionalService profissionalService;

    @Operation(
            summary = "Cadastrar profissional",
            description = "Cadastra um novo profissional e registra a ação na auditoria."
    )
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Profissional cadastrar(@RequestBody @Valid Profissional profissional) {
        return profissionalService.cadastrar(profissional);
    }

    @Operation(
            summary = "Listar profissionais",
            description = "Lista todos os profissionais cadastrados."
    )
    @GetMapping
    public List<Profissional> listar() {
        return profissionalService.listar();
    }
}