package com.clinica.clinica_api.controller;

import com.clinica.clinica_api.adapter.AuditoriaAdapter;
import com.clinica.clinica_api.entity.Profissional;
import com.clinica.clinica_api.repository.AuditoriaRepository;
import com.clinica.clinica_api.repository.ProfissionalRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profissionais")
@RequiredArgsConstructor
public class ProfissionalController {

    private final ProfissionalRepository profissionalRepository;
    private final AuditoriaRepository auditoriaRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Profissional cadastrar(@RequestBody @Valid Profissional profissional) {
        Profissional profissionalSalvo = profissionalRepository.save(profissional);

        auditoriaRepository.save(
                AuditoriaAdapter.profissionalCadastrado(profissionalSalvo)
        ); //colocando a auditoria aqui apenas para não criar um service somente para isso

        return profissionalSalvo;
    }

    @GetMapping
    public List<Profissional> listar() {
        return profissionalRepository.findAll();
    }
}