package com.clinica.clinica_api.controller;

import com.clinica.clinica_api.entity.Auditoria;
import com.clinica.clinica_api.repository.AuditoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auditorias")
@RequiredArgsConstructor
public class AuditoriaController {

    private final AuditoriaRepository auditoriaRepository;

    @GetMapping
    public List<Auditoria> listar() {
        return auditoriaRepository.findAll();
    }
}