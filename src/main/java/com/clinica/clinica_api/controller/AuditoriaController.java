package com.clinica.clinica_api.controller;

import com.clinica.clinica_api.entity.Auditoria;
import com.clinica.clinica_api.repository.AuditoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@Tag(name = "Auditorias", description = "Consulta dos registros de auditoria do sistema")
@RestController
@RequestMapping("/auditorias")
@RequiredArgsConstructor
public class AuditoriaController {

    private final AuditoriaRepository auditoriaRepository;

    @Operation(
            summary = "Listar auditorias",
            description = "Lista os registros de auditoria gerados por cadastros, criações e cancelamentos."
    )
    @GetMapping
    public List<Auditoria> listar() {
        return auditoriaRepository.findAll();
    }
}